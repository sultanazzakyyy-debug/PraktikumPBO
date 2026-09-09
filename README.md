# ✈️ Sistem Pemesanan Tiket Pesawat
### Mini Project 1 — Pemrograman Berorientasi Objek

![Java](https://img.shields.io/badge/Java-26-orange?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-blue?logo=apachemaven&logoColor=white)
![NetBeans](https://img.shields.io/badge/IDE-Apache%20NetBeans-informational?logo=apache&logoColor=white)

</div>

---

## 👤 Identitas

| | |
|---|---|
| **Nama** | Muhammad Nadhir Sultan Azzaky |
| **NIM** | 2509116080 |
| **Kelas** | Sistem Informasi 25'B |
| **Tema** | Sistem Pemesanan Tiket Pesawat |
| **Mini Project** | 1 |

---

## 📑 Daftar Isi

- [Deskripsi Singkat](#-deskripsi-singkat)
- [Struktur Project](#-struktur-project)
- [Penjelasan Class](#-penjelasan-class)
  - [Penumpang.java](#1-penumpangjava)
  - [Penerbangan.java](#2-penerbanganjava)
  - [Tiket.java](#3-tiketjava)
  - [SistemPemesananTiketPesawat.java](#4-sistempemesanantiketpesawatjava)
- [Alur Program](#-alur-program)
- [Uji Coba Program (Screenshot)](#-uji-coba-program-screenshot)

---

## 📝 Deskripsi Singkat

Ini adalah tugas Mini Project 1 buat mata kuliah Pemrograman Berorientasi Objek, dengan tema **Sistem Pemesanan Tiket Pesawat**. Programnya jalan lewat command line (belum ada tampilan GUI), dan intinya buat ngatur data pemesanan tiket pesawat: nambah tiket baru, lihat semua tiket yang udah dibuat, update data tiket, sama hapus tiket.

Semua data disimpan sementara di `ArrayList` selama program masih jalan — jadi kalau program ditutup, datanya hilang (belum disimpan ke file atau database).

Konsep yang dipraktikkan di sini fokus ke dasar-dasar OOP: bikin class, bikin object dari class itu, pakai constructor, dan gimana satu object bisa "membungkus" object lain di dalamnya (misalnya `Tiket` yang di dalamnya ada `Penumpang` dan `Penerbangan`).

---

## 📂 Struktur Project

Project dibuat pakai **Apache NetBeans**, tipe **Java with Maven**, semua class ada dalam satu package:

```
com.mycompany.sistempemesanantiketpesawat
```

```
SistemPemesananTiketPesawat/
├── pom.xml
└── src/main/java/com/mycompany/sistempemesanantiketpesawat/
    ├── Penumpang.java
    ├── Penerbangan.java
    ├── Tiket.java
    └── SistemPemesananTiketPesawat.java   ← entry point (main class)
```

| Class | Peran |
|---|---|
| `Penumpang` | Nyimpen data diri penumpang |
| `Penerbangan` | Nyimpen data jadwal & harga penerbangan |
| `Tiket` | Gabungan `Penumpang` + `Penerbangan`, plus kelas kursi & status |
| `SistemPemesananTiketPesawat` | Main class, isinya menu & semua logika program |

---

## 🧩 Penjelasan Class

### 1. `Penumpang.java`

Atributnya:
- `idPenumpang` — ID unik penumpang
- `nama` — nama penumpang
- `noKTP` — nomor KTP
- `noTelepon` — nomor telepon

Cuma punya satu constructor yang langsung ngisi keempat atribut di atas pas object-nya dibuat.

### 2. `Penerbangan.java`

Atributnya:
- `kodePenerbangan` — kode penerbangan/maskapai
- `asal` — kota keberangkatan
- `tujuan` — kota tujuan
- `jamKeberangkatan` — jam berangkat
- `harga` — harga dasar tiket (tipe `double`)

Sama kayak `Penumpang`, cuma punya constructor buat ngisi atributnya.

### 3. `Tiket.java`

Ini class inti yang nggabungin `Penumpang` dan `Penerbangan` jadi satu data tiket. Atributnya:
- `idTiket` — ID unik tiket
- `penumpang` — object `Penumpang`
- `penerbangan` — object `Penerbangan`
- `kelasKursi` — Ekonomi / Bisnis / First Class
- `statusTiket` — otomatis keisi `"Dipesan"` waktu tiket baru dibuat

Selain constructor, ada 2 method:

- **`hitungTotalHarga()`** — ngitung total harga sesuai kelas kursi:
  - Ekonomi → harga dasar
  - Bisnis → harga dasar × 1.5
  - First Class → harga dasar × 2
- **`tampilkanDetail()`** — nyetak semua detail tiket ke layar (data penumpang, data penerbangan, kelas kursi, total harga, status).

### 4. `SistemPemesananTiketPesawat.java`

Ini main class-nya, isinya:
- `Scanner` buat baca input dari keyboard
- `ArrayList<Tiket> daftarTiket` buat nampung semua tiket yang dibuat
- Loop menu pakai `do-while`, dan `switch` gaya arrow (`->`) buat milih menu

---

## 🔄 Alur Program

1. Program mulai, `ArrayList<Tiket>` masih kosong.
2. Menu ditampilin, ada 5 pilihan:
   ```
   1. Tambah Tiket
   2. Lihat Semua Tiket
   3. Update Tiket
   4. Hapus Tiket
   5. Keluar
   ```
3. User ngetik angka 1–5, dibaca pakai `input.nextLine()` terus diubah ke `int` lewat `Integer.parseInt()`.
4. Program masuk ke `switch`, jalanin salah satu blok sesuai angka yang dipilih:

| Menu | Yang Terjadi |
|---|---|
| **1. Tambah Tiket** | Isi data penumpang → jadi object `Penumpang`. Isi data penerbangan → jadi object `Penerbangan`. Pilih kelas kursi → digabung jadi object `Tiket`, terus dimasukin ke `daftarTiket` pakai `add()`. |
| **2. Lihat Semua Tiket** | Kalau `daftarTiket` masih kosong, kasih tau belum ada data. Kalau nggak, loop `for` dari awal sampai akhir list, terus panggil `tampilkanDetail()` buat tiap tiket. |
| **3. Update Tiket** | User masukin ID tiket, program cari lewat loop `for` sampai ketemu `idTiket` yang cocok. Kalau ketemu, `kelasKursi` dan `statusTiket`-nya bisa diganti. Kalau nggak ketemu, muncul pesan "Tiket tidak ditemukan." |
| **4. Hapus Tiket** | Sama kayak update, dicari dulu pakai loop `for`. Kalau ketemu, tiketnya dibuang dari `daftarTiket` pakai `remove()`. |
| **5. Keluar** | Program nyetak pesan penutup. |
| *(selain itu)* | Muncul pesan "Pilihan tidak tersedia!" lewat `default`. |

5. Setelah satu menu selesai dijalankan (kecuali menu 5), program balik lagi ke langkah 2 — ini kejadian terus karena dibungkus `do-while`.
6. Program cuma berhenti kalau user masukin angka 5, soalnya kondisi loopnya `while (pilihan != 5)`.

---

## 📸 Uji Coba Program (Screenshot)

Bagian ini nunjukkin hasil jalanin program dari awal sampai akhir, satu siklus CRUD penuh (Tambah → Lihat → Update → Lihat lagi → Hapus → Lihat lagi → Keluar), biar kebukti semua fitur bener-bener jalan.

### 1. Tampilan Menu Awal

<img width="220" height="98" alt="Menu awal " src="https://github.com/user-attachments/assets/8f37657d-ed87-424d-ae03-f658b52e554c" />

Ini tampilan pertama yang muncul begitu program di-run. Ada 5 pilihan menu, dan program nunggu user ngetik angka di baris `Pilih menu:`. Ini bagian dari loop `do-while` yang bakal terus nongol lagi tiap habis satu proses selesai.

### 2. Menu 1 — Tambah Tiket

<img width="277" height="158" alt="Menu 1" src="https://github.com/user-attachments/assets/baac1f24-51ed-4f93-8750-b46762997630" />

Di sini user ngetik `1`, terus program minta input satu-satu: ID Tiket, data penumpang (nama, KTP, telepon), data penerbangan (kode, asal, tujuan, jam, harga), sampai kelas kursi. Contoh yang di-input: ID `0001`, penumpang bernama Sultan, penerbangan GA 401 dari Balikpapan ke Bali jam 08.00 dengan harga dasar Rp1.700.000, kelas Ekonomi. Begitu semua keisi, muncul pesan **"Tiket berhasil ditambahkan!"** — tandanya object `Tiket` baru udah kebentuk dan kemasukin ke `ArrayList`.

### 3. Menu 2 — Lihat Semua Tiket (setelah tambah)

<img width="202" height="181" alt="Menu 2" src="https://github.com/user-attachments/assets/699d37d5-607a-4056-91f2-600620348620" />

Setelah balik ke menu dan pilih `2`, tiket yang barusan dibuat langsung muncul detailnya. Kelihatan kelas kursinya masih **Ekonomi**, jadi Total Harga-nya sama persis dengan harga dasar: **Rp1.700.000** (karena Ekonomi nggak ada pengali). Status-nya juga masih **Dipesan**, sesuai default yang di-set di constructor `Tiket`.

### 4. Menu 3 — Update Tiket

<img width="233" height="90" alt="Menu 3" src="https://github.com/user-attachments/assets/504635ef-a931-4a21-aab0-4a8325a3c903" />

Pilih menu `3`, terus masukin ID tiket yang mau diubah (`0001`). Program nunjukkin kelas kursi & status yang sekarang, terus minta nilai barunya. Di percobaan ini, kelas kursi diganti dari **Ekonomi** ke **First Class**, dan status diganti dari **Dipesan** ke **Diterima**. Muncul pesan **"Tiket berhasil diubah!"**.

### 5. Menu 2 — Lihat Semua Tiket (setelah update)

<img width="201" height="191" alt="Menu 2 after menu 3" src="https://github.com/user-attachments/assets/b0015b18-b941-4b90-a9da-1fdf0cd53765" />

Cek lagi lewat menu `2`, dan perubahannya kepake beneran: Kelas Kursi udah jadi **First Class**, dan Total Harga otomatis ke-update jadi **Rp3.400.000** — itu hasil dari `harga dasar × 2` sesuai aturan di method `hitungTotalHarga()`. Status Tiket juga udah berubah jadi **Diterima**. Ini nunjukkin kalau update bener-bener ngubah data di object yang sama, bukan bikin data baru.

### 6. Menu 4 — Hapus Tiket

<img width="235" height="39" alt="Menu 4" src="https://github.com/user-attachments/assets/eecf2fe8-22aa-4ef8-8b17-dc60d09a255b" />

Pilih menu `4`, masukin ID `0001`, dan program langsung ngasih tau **"Tiket berhasil dihapus."** — artinya tiket itu udah dibuang dari `ArrayList` pakai `remove()`.

### 7. Menu 2 — Lihat Semua Tiket (setelah hapus)

<img width="131" height="47" alt="Menu 2 after menu 4" src="https://github.com/user-attachments/assets/8c65748d-5ce8-426e-9a6d-0058cdafb1ea" />

Dicek sekali lagi lewat menu `2`, dan sekarang programnya bilang **"Belum ada data tiket."** — soalnya `daftarTiket` udah kosong lagi (`size() == 0`), sesuai kondisi yang dicek sebelum masuk ke loop `for` buat nampilin data.

### 8. Menu 5 — Keluar

<img width="409" height="102" alt="Menu 5" src="https://github.com/user-attachments/assets/e055e29f-09d9-4eac-a441-11281915c098" />

Terakhir, pilih menu `5`, program nyetak pesan **"Terima kasih telah menggunakan sistem ini!"** dan loop `do-while` berhenti karena kondisi `pilihan != 5` udah nggak terpenuhi lagi. Program pun selesai (`BUILD SUCCESS`).
