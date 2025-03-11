Penyelesaian : 
1. Download terlebih dahulu file dist.zip
2. Lihat komentar pada file zip tersebut berisi sebuah hash md5 lalu kita crack hash tersebut menggunakan online tool atau alat hash cracker ditemukan iloveu2 sebagai password
3. Berhasil ekstrak kita mendapatkan file wall2.zip kita perlu melakukan cracking lagi menggunakan tool johntheripper dan menggunakan wordlist rockyou.txt dan didapatkan password greenday
4. Kita lihat lagi komentarnya dan ada sebuah base64 dan juga password jika kita decrypt base64 pada komentar kita akan mendapatkaan kata password jadi isi komentar tersebut adalah password : mengcetef jika kita coba memasukan password mengcetef maka tidak akan berhasil jadi kita perlu membuat menjadi base64 dan masukan hasil base54 dari password mengcetef ('bWVuZ2NldGVm') ke file zip maka file zip akan berhasil terekstrak.
5. Berhasil mengekstrak file zip kita mendapat k 1 file png yang rusak untuk itu kita harus memperbaikinya menggunakan hex editor yang perlu menjadi perhatian adalah
header, ukuran panjang x lebarnya (1000 x 614), dan penutup atau hex paling bawah pada file png
6. setelah merecover kita perlu memutar terlebih dahulu file png tersebut lalu kita decrypt tulisan acak yang tertulis di file png tersebut. kita bisa menggunakan cipher identifier. pertama kita decrypt dari base85 setelah itu output dari base85 kita decrypt ke base64 dan selamat kita telah mendapatkan flag.

flag = flag{mr_bl4ck_y0ur_1m4g3_h@5_b33n_r3c0v3r3d}