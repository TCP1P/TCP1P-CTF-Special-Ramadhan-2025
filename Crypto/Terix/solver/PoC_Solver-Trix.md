### Proof Of Concept
Title   : Terix
Type    : Easy - Cryptography
By @WanZKey

## Summary  :
Pada Tantangan ini menguji pemahaman peserta dalam memanipulasi representasi matriks dari teks dalam kriptografi AES.
Peserta diberikan matriks terenkripsi yang harus dikonversi kembali menjadi string asli menggunakan fungsi transformasi.

## Overview :
Tantangan ini menguji pemahaman peserta dalam memanipulasi representasi matriks dari teks dalam kriptografi AES.
Peserta diberikan matriks terenkripsi yang harus dikonversi kembali menjadi string asli menggunakan fungsi transformasi.


## Solution :
Peserta hanya perlu mengubah matrix tersebut kembali menjadi sebuah strings untuk mendapatkan flagnya.

Berikut skrip solver untuk menyelesaikan tantangan ini:

# Skrip Solver:

#@WanZKey
def bytes2matrix(text):
    """ Converts a 16-byte array into a 4x4 matrix.  """
    return [list(text[i:i+4]) for i in range(0, len(text), 4)]

def matrix2bytes(matrix):
    """ Converts a 4x4 matrix into a 16-byte array.  """
    return b"".join(bytes(row) for row in matrix)

matrix = [
    [82, 65, 77, 65],
    [68, 65, 78, 123],
    [69, 52, 115, 121],
    [45, 99, 104, 52],
    [108, 108, 95, 77],
    [52, 116, 114, 49],
    [120, 33, 125, 33]
]

print(matrix2bytes(matrix))


# Hasil Script Solver:
┌──(wanzkey㉿Hengker-Bwang)-[~/Projec-TCP1P/Crypto/Trix]
└─$ python3 solver.py
b'RAMADAN{E4sy-ch4ll_M4tr1x!}!'

#Flag: RAMADAN{E4sy-ch4ll_M4tr1x!}  
