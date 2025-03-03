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
