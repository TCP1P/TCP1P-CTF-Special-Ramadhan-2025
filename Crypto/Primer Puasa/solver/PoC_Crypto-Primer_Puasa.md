### Proof Of Concept
Title   : Primer Puasa
Type    : Medium - Cryptography
By @WanZKey


## Summary  :
Pada tantangan Crypto ini menggunakan enkripsi RSA dengan enkripsi 128bit.


## Overview :
Pada tantangan ini peserta diberikan 2 buah file yakni chall.py dan output.txt, chall.py merupakan mekanisme tantangan ini
sedangkan file output.txt merupakan file yang perlu didekripsi oleh peserta untuk mendapatkan flagnya.


## Solution :
Peserta memerlukan membuat sebuah script solve dengan menggunakan library nextPrime, karena
enkripsi yang pada file ouput.txt tersebut diharus kan didekripsi dengan bilangan prima yang besar.

*Syarat untuk menjalankan script solve ini adalah dengan 1 direktori dengan file output.txt.

Berikut script solve untuk tantangan ini:

# Skrip Solver:

#@WanZKey
#Only 128 Bit right?, Yes, it's very easy!

import ast

import sympy
from Crypto.Util.number import long_to_bytes

with open("output.txt") as f:
    n = ast.literal_eval(f.readline().split("=")[1])
    e = ast.literal_eval(f.readline().split("=")[1])
    c = ast.literal_eval(f.readline().split("=")[1])
    r = ast.literal_eval(f.readline().split("=")[1])


def bin_search(n: int, r: int) -> int:
    low = 0
    high = 1 << 256
    mid = 0
    while low < high:
        mid = (low + high) // 2
        q = mid
        p: int = q * sympy.nextprime(r) + sympy.nextprime(q) * r  # type: ignore
        # print((n - (p * q)))
        if p * q >= n:
            high = mid
        else:
            low = mid + 1
    return mid


q = bin_search(n, r)
print(f"{q = }")
assert n % q == 0
p = n // q
phi = (p - 1) * (q - 1)
d = pow(e, -1, phi)
p = pow(c, d, n)
print(long_to_bytes(p))



# Hasil Script Solve:
┌──(wanz)─(wanzkey㉿Hengker-Bwang)-[~/Projec-TCP1P/Crypto/Primer Puasa/solver]
└─$ python3 solver.py
q = 183241273991286504943988493513185575127
b'RAMADAN{Puas4-g4s_Crypt0-C0y_bi4r_Pr1me!!!}'

#Flag: RAMADAN{Puas4-g4s_Crypt0-C0y_bi4r_Pr1me!!!}
