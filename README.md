
# Simulasi Manajemen Stres Mahasiswa 

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



- Bahasa Pemrograman: **Java**
- IDE: **NetBeans**
- Input Terminal (Scanner)






// Superclass
class DayLog {
    protected int studyHours;
    protected int funHours;
    protected int sleepHours;

    public DayLog(int study, int fun, int sleep) {
        this.studyHours = study;
        this.funHours = fun;
        this.sleepHours = sleep;
    }

    public int getStressLevel() {
        int stress = 0;
        if (studyHours > 6) stress += 2;
        if (funHours < 2) stress += 1;
        if (sleepHours < 6) stress += 2;
        return stress;
    }

    public int getProductivityScore() {
        return (studyHours * 2) + sleepHours - funHours;
    }

    public void showFeedback(int dayNumber) {
        System.out.println("Hari ke-" + (dayNumber + 1));
        System.out.println("Jam Belajar : " + studyHours);
        System.out.println("Jam Bermain : " + funHours);
        System.out.println("Jam Tidur   : " + sleepHours);
        System.out.println("Tingkat Stres        : " + getStressLevel());
        System.out.println("Skor Produktivitas   : " + getProductivityScore());
        System.out.println("----------------------------------");
    }
}

// Subclass untuk weekday
class WeekdayLog extends DayLog {
    public WeekdayLog(int study, int fun, int sleep) {
        super(study, fun, sleep);
    }

    @Override
    public int getStressLevel() {
        int stress = super.getStressLevel();
        if (studyHours > 7) stress += 1;
        return stress;
    }
}

// Subclass untuk weekend
class WeekendLog extends DayLog {
    public WeekendLog(int study, int fun, int sleep) {
        super(study, fun, sleep);
    }

    @Override
    public int getStressLevel() {
        int stress = super.getStressLevel();
        if (sleepHours < 7) stress += 2;
        return stress;
    }
}

public class StudyStressSimulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DayLog[] weekLogs = new DayLog[7];

        System.out.println("=== Simulasi Manajemen Waktu & Stres ===");

        for (int day = 0; day < 7; day++) {
            System.out.println("\nHari ke-" + (day + 1) + (day < 5 ? " (Weekday)" : " (Weekend)"));

            int study = getValidInput(input, "Masukkan jam belajar (0-10): ", 0, 10);
            int fun = getValidInput(input, "Masukkan jam bermain (0-10): ", 0, 10);
            int sleep = getValidInput(input, "Masukkan jam tidur (0-12): ", 0, 12);

            DayLog log;
            if (day < 5) {
                log = new WeekdayLog(study, fun, sleep);
            } else {
                log = new WeekendLog(study, fun, sleep);
            }

            weekLogs[day] = log;
            log.showFeedback(day);
        }

        int totalStress = 0;
        int totalProductivity = 0;

        for (DayLog log : weekLogs) {
            totalStress += log.getStressLevel();
            totalProductivity += log.getProductivityScore();
        }

        System.out.println("\n=== RINGKASAN MINGGUAN ===");
        System.out.println("Total Tingkat Stres: " + totalStress);
        System.out.println("Total Produktivitas: " + totalProductivity);

        if (totalStress > 18) {
            System.out.println("Kamu terlalu stres minggu ini. Pertimbangkan keseimbangan belajar dan istirahat.");
        } else {
            System.out.println("Minggu yang seimbang. Pertahankan kebiasaan baikmu.");
        }

        input.close();
    }

    private static int getValidInput(Scanner input, String prompt, int min, int max) {
        int value = -1;
        while (true) {
            try {
                System.out.print(prompt);
                value = input.nextInt();
                if (value >= min && value <= max) break;
                System.out.println("Nilai harus antara " + min + " - " + max);
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.nextLine();
            }
        }
        return value;
    }
}

Poin Poin Penilaian Yang Terpenuhi :

1. Class
✔ Terpenuhi
Kelas-kelas yang dideklarasikan:

DayLog

WeekdayLog

WeekendLog

StudyStressSimulation

2. Object
✔ Terpenuhi
Objek-objek dibuat dalam main:

DayLog log; // superclass reference
log = new WeekdayLog(...); // atau WeekendLog(...)
weekLogs[day] = log;
 3. Atribut
✔ Terpenuhi
Atribut dalam class:

protected int studyHours;
protected int funHours;
protected int sleepHours;
4. Constructor
✔ Terpenuhi
Constructor di masing-masing class:

public DayLog(int study, int fun, int sleep) { ... }
public WeekdayLog(int study, int fun, int sleep) { super(...); }
public WeekendLog(int study, int fun, int sleep) { super(...); }
5. Mutator (Setter)
✔ Tidak eksplisit ada setter method (seperti setStudyHours()), tapi bisa dianggap implisit dalam constructor karena nilai atribut diubah di sana.

6. Accessor (Getter)
✔ Terpenuhi
Contoh:

public int getStressLevel() { ... }
public int getProductivityScore() { ... }
 7. Encapsulation
✔ Terpenuhi
Penggunaan protected pada atribut dan public pada method adalah bentuk enkapsulasi. Atribut tidak diakses langsung dari luar, tapi melalui konstruktor dan method.

8. Inheritance
✔ Terpenuhi
Kelas WeekdayLog dan WeekendLog adalah turunan dari DayLog:

class WeekdayLog extends DayLog
class WeekendLog extends DayLog
9. Polymorphism
✔ Terpenuhi
Contoh:

DayLog log; // reference superclass
log = new WeekdayLog(...); // objek subclass
log.getStressLevel(); // pemanggilan method overridden (runtime polymorphism)
 10. Seleksi (Percabangan)
✔ Terpenuhi
Contoh:

if (studyHours > 6) stress += 2;
if (funHours < 2) stress += 1;
11. Perulangan
✔ Terpenuhi
Contoh:

for (int day = 0; day < 7; day++) { ... }
 12. IO Sederhana
✔ Terpenuhi
Menggunakan Scanner untuk input:

Scanner input = new Scanner(System.in);
System.out.print("Masukkan jam belajar: ");
 13. Array

Deklarasi dan penggunaan array:

DayLog[] weekLogs = new DayLog[7];
 14. Error Handling
✔ Terpenuhi
Try-catch dalam getValidInput:

try {
   value = input.nextInt();
} catch (Exception e) {
   System.out.println("Input tidak valid. Masukkan angka.");
   input.nextLine();
}

