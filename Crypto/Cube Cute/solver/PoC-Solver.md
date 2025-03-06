### Proof Of Concept
Title   : Cube Cute
Type    : Easy->Hard - Cryptography
By @WanZKey

## Summary : 
Pada tantangan Cryptography kali ini, peserta diberikan sebuah output ciphertext yang telah dienkripsi dengan metode RSA modulus n = p³ (kubus bilangan prima).


## Overview : 
Peserta diberikan 2 file, yakni chall.py dan output.txt, chall.py merupakan file mekanisme enrkipsi yang digunakan 
dalam tantangan cryptography ini, sedangkan output.txt merupakan keluaran/output flag yang telah dienkripsi tersebut (ciphertext).

	# Konsep Kriptografi:
	- Struktur Modulus	: n = p³ → φ(n) = p²(p-1).
	- RSA Custom		: Dekripsi memerlukan perhitungan d menggunakan φ(n) yang tidak standar.

## Solution :
1. Cari Akar Kubik (n)		= p = integer_cube_root(n) -> p = ?...	
2. Hitung (Phi) φ(n)		= phi = p² * (p - 1).
3. Hitung Private Key (d)	= d = inverse(e, phi).
4. Dekripsi Ciphertext		= m = pow(c, d, n).
5. Konversi ke Teks		= flag = long_to_bytes(m).decode().
 
Berikut Script Solver untuk menyelesaikan tantangan ini:

	#Script Solver:
		#@WanZKey

		from Crypto.Util.number import long_to_bytes, inverse

		#Output.txt
		n = 630898657746765099122267528399725208189145247063682480924052168875604652609906980974582055383403839197154487585764970168295427913822134040973976165185049867109163706600223414592995357912884480125931297182733092986951525729943417082503377207750215095866659544261732457343170292593849656732143202362036798588858712097255250807514111870212119582395370012616879339177777597009269762479875901203517374464318585932616520746594131938550191763226024716780709090409632501
		c = 566743658504610440666264570638634074273227110512101941192700827572262701380197987965724054202703078978793507864216820035950605301514782676829822525720770360686370257756515710853079962416300618585428543316192254417606542328610233935356522610247094462983431467069120612826495791771825504581081875258763019103278418007670583009168669348938222110660323577629493389539178804812907782381802089745317531681334924267970208266019479367907744408789540835482489133197924000

		e = 65537

		def integer_cube_root(n):
    			low = 1
    			high = 2
    			while high ** 3 < n:
        		   high *= 2
    			while low <= high:
        		   mid = (low + high) // 2
        		   mid_cubed = mid ** 3
        		   if mid_cubed < n:
            			low = mid + 1
        		   elif mid_cubed > n:
            			high = mid - 1
        		   else:
            			return mid
    			   return None

		p = integer_cube_root(n)
		phi = p ** 2 * (p - 1)
		d = inverse(e, phi)
		m = pow(c, d, n)
		flag = long_to_bytes(m).decode()

		print(flag)


	# Output Script:
	┌──(wanz)─(wanzkey㉿Hengker-Bwang)-[~/Projec-TCP1P/Crypto/Cube Cute/solver]
	└─$ python3 solver.py
	RAMADAN{Lag1-Pu4s4_b3laj4r_Cub3-r0ot-C4lcul4t0r}
	
#Flag: RAMADAN{Lag1-Pu4s4_b3laj4r_Cub3-r0ot-C4lcul4t0r}
