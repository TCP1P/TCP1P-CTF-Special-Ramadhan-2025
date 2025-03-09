# u-turn

- `scanf` always adds a null byte at the end of your input
- The buffer is 256 bytes long and `scanf` scans 256 bytes of input, so it'll put a null byte at the 257th byte, thus causing an overflow
- The data being overflown is the saved `rbp` of the previous stack frame
- Thankfully, the saved `rbp` doesn't start with a null byte too, so the overflow will actually accomplish something
- By changing the LSB of the saved `rbp` to `\x00`, you're essentially moving the saved `rbp` a little bit down on the stack
- A little bit down on the stack is also where our input buffer is stored
- Thus, after 2 `leave` instructions, our `rsp` will now point to our altered saved `rbp`, or in other words, the input buffer which we control
- So, we can send a ROP chain as input and `rsp` will eventually point there
- But since ASLR is enabled, the value of the saved `rbp` will be randomized, so we can add multiple `ret`s before our actual ROP chain as padding to get a better chance of actually hitting our ROP chain, similar to how a nop sled works in shellcode
- The first part of the ROP chain is responsible for leaking a libc address.
- In glibc 2.35, after a call to `printf`, the `rdi` register will be loaded with an address that points to `funlockfile`, a function in libc
- So, we can call `printf` a second time to print out the address of that `funlockfile`
- To get the base, just subtract the offset of `funlockfile` from the leak
- The second part of the ROP chain is another stack pivot to overwrite the GOT entry of `printf`
- We overwrite it to a one gadget. The correct one gadget can be found through trial and error, i.e. trying every one gadget and see which one works
- Finally, the solver is run in a for loop because it might not work the first time due to ASLR.