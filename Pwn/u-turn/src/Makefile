build:
	gcc -S -O0 -fno-builtin-printf -fno-omit-frame-pointer -fno-stack-protector -no-pie -Wl,-z,relro -o chall.s chall.c
	sed -i 's/popq[[:space:]]*%rbp/leave/' chall.s
	gcc -O0 -fno-builtin-printf -fno-omit-frame-pointer -fno-stack-protector -no-pie -Wl,-z,relro -o chall chall.s
