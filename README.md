
# Simulasi Manajemen Stres Mahasiswa 🧠📚

## Deskripsi Proyek
Program ini merupakan simulasi manajemen waktu dan stres mahasiswa selama 7 hari. Pengguna memasukkan data harian berupa:
- Jam belajar
- Jam bermain
- Jam tidur

Program kemudian menghitung:
- Tingkat stres harian
- Skor produktivitas
- Total stres mingguan
- Rekomendasi untuk manajemen waktu

## Tujuan
Membantu mahasiswa memahami keseimbangan antara belajar, hiburan, dan istirahat, serta dampaknya terhadap stres dan produktivitas.

---

## Fitur
✅ Input jam belajar, bermain, dan tidur per hari  
✅ Penyesuaian stres berdasarkan hari kerja vs akhir pekan  
✅ Umpan balik (feedback) harian  
✅ Ringkasan mingguan total stres & produktivitas  
✅ Rekomendasi berdasarkan total stres  

---

## Struktur Kode
- `DayLog` → Kelas induk (Superclass) untuk menyimpan data harian
- `WeekdayLog` & `WeekendLog` → Subclass untuk menyesuaikan stres berdasarkan hari
- `StudyStressSimulation` → Kelas utama yang menjalankan simulasi

---

## Cara Menjalankan
1. Buka NetBeans dan buat project Java bernama `StudyStressSimulation`
2. Buat file `StudyStressSimulation.java`
3. Salin seluruh kode program ke file tersebut
4. Jalankan program dan masukkan data sesuai petunjuk di terminal

---

## Contoh Output
```
=== Simulasi Manajemen Waktu & Stres ===

Hari ke-1 (Weekday)
Masukkan jam belajar (0-10): 6
Masukkan jam bermain (0-10): 3
Masukkan jam tidur (0-12): 7
Tingkat Stres        : 0
Skor Produktivitas   : 16
...
=== RINGKASAN MINGGUAN ===
Total Tingkat Stres: 12
Total Produktivitas: 98
Minggu yang seimbang. Pertahankan kebiasaan baikmu.
```

---

## Teknologi yang Digunakan
- Bahasa Pemrograman: **Java**
- IDE: **NetBeans**
- Input Terminal (Scanner)

---

## Lisensi
Proyek ini dibuat untuk tujuan pembelajaran dan simulasi akademik.
