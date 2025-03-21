#@WanZKey

import struct

# Fungsi packing/unpacking 64-bit integer
p64 = lambda x: struct.pack('<Q', x)
u64 = lambda x: struct.unpack('<Q', x)[0]

# Data dari output.txt
enc_hex = "a6d869161e868078527902778bb36050aca976082df6ba6b550a126ba3ec244fac93043e2dffb968551d1169a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a2e25771ceaae6d01"
enc_data = bytes.fromhex(enc_hex)

# Memisahkan IV dan Ciphertext
KEY_SIZE = 8
iv = enc_data[:KEY_SIZE]
ciphertext = enc_data[KEY_SIZE:]

# Kita tahu kalau format FLAG nya itu diawali dengan "RAMADAN{"
known_plaintext_prefix = b"RAMADAN{"

# Menghitung kunci
c1 = iv
c2 = ciphertext[:KEY_SIZE]
key = p64(u64(c1) ^ u64(c2) ^ u64(known_plaintext_prefix))

# Dekripsi ciphertext
plaintext = b''
prev_cipher = iv
for i in range(0, len(ciphertext), KEY_SIZE):
    c_block = ciphertext[i:i+KEY_SIZE]
    p_block = p64(u64(prev_cipher) ^ u64(c_block) ^ u64(key))
    plaintext += p_block
    prev_cipher = c_block

# Ekstrak flag dari plaintext (hilangkan padding)
flag = plaintext.split(b'}')[0] + b'}'

print("Eaa nih mas hasilnya:", flag.decode())
print("Ciee dapet nie flagnya")
