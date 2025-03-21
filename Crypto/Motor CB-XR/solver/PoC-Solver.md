### Proof Of Concept
Title   : Motor CB-XR
Type    : Easy->Medium - Cryptography
By @WanZKey

## Summary :
Pada tantangan Kriptografi ini, peserta diharapkan bisa memahami mengenai alogritma enkripsi XOR-CBC menggunakan skema 12 Block dengan 96 Bytes, tujuan tantangan ini adalah
beserta dapat memulihkan "output.txt" file tersebut di dekripsi kembali agar dapat mengetahui isi file tersebut, karena flagnya berada di file "output.txt" tersebut.


## Overview :
Pada file "chall.py" merupakan isi file yang berisi informasi mengenai algoritma enkripsi apa yang digunakan.
sedangkan file "output.txt" tersebut merupakan file yang telah dienkripsi, jadi ini adalah tugas peserta untuk melakukan dekripsi kembali menjadi plaintext semula.


# Tabel Konsep Algoritma Enkripsi XOR-CBC
----------------------------------------------
plain 0       plain 1       plain 2
        |             |             |
        v             v             v
IV --> XOR  +------> XOR  +------> XOR
        |   |         |   |         |
        v   |         v   |         v
key -> XOR  | key -> XOR  | key -> XOR
        |   |         |   |         |
        +---+         +---+         |
        |             |             |
        v             v             v
[IV] [cipher 0]    [cipher 1]    [cipher 2]
----------------------------------------------


## Solution :
1. Parse the ciphertext/Menguraikan CipherText
   Pertama, kita perlu mengurai ciphertext yang diberikan dan memisahkan IV dari sisa data.

2. Recover the key/Memulihkan Kunci
   Kedua, karna sudah mengetahui format awal flag yakni "RAMADAN{", kita dapat mencari/memulihkan kuncinya.

3. Decrypt the ciphertext/ Melakukan Dekripsi Pada Ciphertext
   ketiga, sekarang jika sudah mendapatkan "Key", kita dapat mendekripsi seluruh ciphertext tersebut menjadi plaintext/teks normal kembali.


Berikut implementasi Script Solver untuk menyelesaikan tantangan ini:

#Script Solver:
	#@WanZKey

	import struct

	# Fungsi packing/unpacking 64-bit integer
	p64 = lambda x: struct.pack('<Q', x)
	u64 = lambda x: struct.unpack('<Q', x)[0]

	# Data dari output.txt
	enc_hex = "a6d869161e868078527902778bb36050aca976082df6ba6b550a126ba3ec244fac93043e2dffb968551d1169a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a2e25771ceaae6d01"
	enc_data = bytes.fromhex(enc_hex)

	# Memisahkan IV dan Ciphertext
	KEY_SIZE = 8
	iv = enc_data[:KEY_SIZE]
	ciphertext = enc_data[KEY_SIZE:]

	# Kita tahu kalau format FLAG nya itu diawali dengan "RAMADAN{"
	known_plaintext_prefix = b"RAMADAN{"

	# Menghitung kunci
	c1 = iv
	c2 = ciphertext[:KEY_SIZE]
	key = p64(u64(c1) ^ u64(c2) ^ u64(known_plaintext_prefix))
		
	# Dekripsi ciphertext
	plaintext = b''
	prev_cipher = iv
	for i in range(0, len(ciphertext), KEY_SIZE):
	    c_block = ciphertext[i:i+KEY_SIZE]
	    p_block = p64(u64(prev_cipher) ^ u64(c_block) ^ u64(key))
	    plaintext += p_block
	    prev_cipher = c_block

	# Ekstrak flag dari plaintext (hilangkan padding)
	flag = plaintext.split(b'}')[0] + b'}'

	print("Eaa nih mas hasilnya:", flag.decode())
	print("Ciee dapet nie flagnya")




# Output Script:
	┌──(wanz)─(wanzkey㉿Hengker-Bwang)-[~/Projec-TCP1P/Crypto/Motor CB-XR/solver]
	└─$ python3 solver.py
	Eaa nih mas hasilnya: RAMADAN{X0R_w1th_CBC_n0w_y0u_g3t_n3w_l3ss0n}
	Ciee dapet nie flagnya


#Flag: RAMADAN{X0R_w1th_CBC_n0w_y0u_g3t_n3w_l3ss0n}
