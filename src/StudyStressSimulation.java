import java.util.Scanner;

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