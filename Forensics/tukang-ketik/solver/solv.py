# tshark -r packet.pcapng -Y "frame.len == 48" -Tfields -e "usb.capdata"

#!/usr/bin/env python3
import subprocess

# USB HID usage mapping:
# Each key is a USB HID keycode with a tuple: (normal, shifted)
usb_hid_usage = {}

# Letters: 0x04 to 0x1D => a - z (shift gives A - Z)
for code in range(0x04, 0x1E):
    usb_hid_usage[code] = (chr(ord('a') + code - 0x04), chr(ord('A') + code - 0x04))

# Digits: 0x1E to 0x27
usb_hid_usage[0x1E] = ('1', '!')
usb_hid_usage[0x1F] = ('2', '@')
usb_hid_usage[0x20] = ('3', '#')
usb_hid_usage[0x21] = ('4', '$')
usb_hid_usage[0x22] = ('5', '%')
usb_hid_usage[0x23] = ('6', '^')
usb_hid_usage[0x24] = ('7', '&')
usb_hid_usage[0x25] = ('8', '*')
usb_hid_usage[0x26] = ('9', '(')
usb_hid_usage[0x27] = ('0', ')')

# Space key (often 0x2C)
usb_hid_usage[0x2C] = (' ', ' ')

# Common symbols:
usb_hid_usage[0x2D] = ('-', '_')  # Dash/Underscore: unshifted '-' ; shifted '_'
usb_hid_usage[0x2E] = ('=', '+')
usb_hid_usage[0x2F] = ('[', '{')  # Open bracket / Open brace
usb_hid_usage[0x30] = (']', '}')  # Close bracket / Close brace
usb_hid_usage[0x31] = ('\\', '|')

# Other keys (optional)
usb_hid_usage[0x28] = ('[ENTER]', '[ENTER]')  # Enter key
usb_hid_usage[0x2A] = ('[BKSP]', '[BKSP]')      # Backspace
usb_hid_usage[0x2B] = ('\t', '\t')              # Tab

def translate_key(modifier, keycode):
    """
    Translates a key press from a USB HID report.
    
    modifier: first byte of the report (bitmask for Shift, Ctrl, etc.)
    keycode: the actual key code (from the 3rd byte of the report)
    
    This function selects the shifted or normal mapping based on the modifier.
    If Control is active, the output is prefixed with "CTRL+" (or for letters, using caret notation).
    """
    # If no key is pressed, keycode is 0.
    if keycode == 0:
        return ""
    
    # Check modifier bits:
    # Bit 1 (0x02) and Bit 5 (0x20) represent left and right Shift.
    shift = bool(modifier & (0x02 | 0x20))
    # Bit 0 (0x01) and Bit 4 (0x10) represent left and right Control.
    ctrl = bool(modifier & (0x01 | 0x10))
    
    if keycode in usb_hid_usage:
        normal, shifted_val = usb_hid_usage[keycode]
        char = shifted_val if shift else normal
    else:
        char = f"[0x{keycode:02x}]"
    
    # If Control modifier is active, modify the output.
    if ctrl:
        # For alphabetic characters, display using caret notation.
        if char.isalpha():
            char = f"^{char.upper()}"
        else:
            char = f"CTRL+{char}"
    
    return char

def run_tshark():
    """
    Executes the tshark command to extract usb.capdata from the pcapng file.
    Returns a list of output lines.
    """
    command = 'tshark -r packet.pcapng -Y "frame.len == 48" -Tfields -e "usb.capdata"'
    try:
        result = subprocess.run(command, shell=True, capture_output=True, text=True, check=True)
        return result.stdout.splitlines()
    except subprocess.CalledProcessError as e:
        print("Error running tshark:", e)
        return []

def process_report(line):
    """
    Processes a single tshark output line.
    
    The report is assumed to be 8 bytes represented in hex.
    The first byte is the modifier, the second is reserved,
    and the third byte is the keycode we care about.
    
    Returns the translated character.
    """
    line = line.strip()
    if not line:
        return ""
    
    # If the line is space separated, split on whitespace.
    # Otherwise, split every 2 characters (for a contiguous hex string).
    tokens = line.split() if " " in line else [line[i:i+2] for i in range(0, len(line), 2)]
    if len(tokens) < 3:
        return ""
    
    try:
        modifier = int(tokens[0], 16)
        keycode = int(tokens[2], 16)
    except ValueError:
        return ""
    
    return translate_key(modifier, keycode)

def main():
    lines = run_tshark()
    output_chars = []
    
    for line in lines:
        translated = process_report(line)
        if translated:
            output_chars.append(translated)
    
    mapped_output = "".join(output_chars)
    print("Mapped keys:", mapped_output)

if __name__ == "__main__":
    main()
