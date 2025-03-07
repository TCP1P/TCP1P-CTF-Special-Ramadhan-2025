# Solana CTF Challenge: The Vulnerable Vault

## Challenge Description

Welcome to the Vulnerable Vault challenge! Your mission is to exploit a vulnerability in a Solana program that manages a secure vault system. Each vault has an owner and is protected by a password.

The program appears to be secure at first glance, with the following functionality:
- Initialize a new vault with a password
- Attempt to solve the vault by providing the correct password
- Check if a vault has been solved

However, there's a critical security flaw in the implementation. Can you find it and exploit it to solve someone else's vault without knowing their password?

## Setup

1. Clone this repository
2. Install dependencies:
```bash
npm install
```
3. Build the program:
```bash
anchor build
```

## Challenge Goal

Your objective is to set the `solved` flag to `true` on a vault that you don't own and don't know the password for.

## Hints
1. Look carefully at the account validation in the `solve` instruction
2. Think about what checks are missing in the program
3. Remember that Solana programs should always validate account ownership and relationships

## Flag Format
The flag will be revealed when you successfully exploit the vulnerability and set `solved = true` on someone else's vault.

Good luck! 