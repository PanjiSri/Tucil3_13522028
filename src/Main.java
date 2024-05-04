import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String WORDS_FILE_PATH = "words_alpha.txt";

    public static void main(String[] args) {

        //biar keren
        System.out.println("=======================================");
        System.out.println("|      Selamat Datang di Program       |");
        System.out.println("|            Tucil 3 STIMA             |");
        System.out.println("|              13522028                |");
        System.out.println("=======================================");

        Scanner scanner = new Scanner(System.in);

        List<String> dictionary = loadDictionary();

        String start, goal;
        do {
            // Input kata awal
            System.out.print("Ketikkan Kata Mulai: ");
            start = scanner.nextLine().trim().toUpperCase();

            // Input kata tujuan
            System.out.print("Ketikkan Kata Tujuan: ");
            goal = scanner.nextLine().trim().toUpperCase();

            // Validasi panjang kata
            if (start.length() != goal.length()) {
                System.out.println("Kata awal dan kata tujuan harus memiliki panjang yang sama.");
                continue;
            }

            // Validasi hanya huruf abjad
            if (!start.matches("[A-Z]+") || !goal.matches("[A-Z]+")) {
                System.out.println("Kata hanya boleh terdiri dari huruf abjad.");
                continue;
            }

            // Validasi kata ada di dalam dictionary
            if (!dictionary.contains(start) || !dictionary.contains(goal)) {
                System.out.println("Kata tidak ditemukan di kamus.");
                continue;
            }

            break; 

        } while (true);

        int choice;
        // Pilihan algoritma 
        do {
            System.out.println("Pilih Algoritma:");
            System.out.println("1. UCS (Uniform Cost Search)");
            System.out.println("2. A*");
            System.out.println("3. Greedy Best First Search");
            System.out.print("Masukkan pilihanmu (1/2/3): ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
                
            if (!(choice == 1 || choice == 2 || choice == 3)) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }

            break;
        
        } while (true);

        SearchAlgorithm searchAlgorithm = null;

        switch (choice) {
            case 1:
                searchAlgorithm = new UCS(start, goal);
                break;
            case 2:
                searchAlgorithm = new A_Star(start, goal);
                break;
            case 3:
                searchAlgorithm = new Greedy(start, goal);
                break;
            default:
                System.out.println("Ada Masalah Pada Pilihan");
                System.out.println("Keluar...");
                System.exit(0);
        }

        // Menjalankan algoritma 
        if (searchAlgorithm != null) {
            searchAlgorithm.printWordStartGoal();
            System.out.println("Loading...");
            searchAlgorithm.algorithm();
        }

        scanner.close();
    }

    // Method untuk kata-kata dari file words_alpha.txt ke dalam ArrayList
    private static List<String> loadDictionary() {
        List<String> dictionary = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(WORDS_FILE_PATH));
            while (fileScanner.hasNextLine()) {
                dictionary.add(fileScanner.nextLine().trim().toUpperCase());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File words_alpha.txt tidak ditemukan.");
            e.printStackTrace();
        }
        return dictionary;
    }
}
