1. Gambar terlihat normal tidak ada anomali jika dijalankan
2. Terdapat fake flag jika peserta membrute force passphrase
gambar menggunakan rockyou
3. Peserta menganalisis hex yang terdapat pada gambar
4. Pada line 00000220 (xxd) terdapat pola bacon cipher 
00000220: 89aa aaab aaab baab aaaa aaab baaa aabb 
00000230: aaba ba0b babb aaaa aaaa abab baaa aaaa 
00000240: babb aaaa bbaa abba abaa aaaa abba aaaa
00000250: bbaa baba bbab baaa aaaa abaa aaaa baab 
00000260: baaa babb ab8a 9293 9495 9697 9899 9aa2
5. decode bacon cipher nya
6. wrap string nya dengan RAMADAN{}