import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String WORDS_FILE_PATH = "dictionary.txt";

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
            start = scanner.nextLine().trim().toLowerCase();

            // Input kata tujuan
            System.out.print("Ketikkan Kata Tujuan: ");
            goal = scanner.nextLine().trim().toLowerCase();

            // Validasi panjang kata
            if (start.length() != goal.length()) {
                System.out.print("\n");
                System.out.println("*");
                System.out.println("**");
                System.out.println("Peringatan : Kata awal dan kata tujuan harus memiliki panjang yang sama.");
                System.out.println("**");
                System.out.println("*");
                System.out.print("\n");
                continue;
            }

            // Validasi hanya huruf abjad
            if (!start.matches("[a-z]+") || !goal.matches("[a-z]+")) {
                System.out.print("\n");
                System.out.println("*");
                System.out.println("**");
                System.out.println("Peringatan : Kata hanya boleh terdiri dari huruf abjad.");
                System.out.println("**");
                System.out.println("*");
                System.out.print("\n");
                continue;
            }

            // Validasi kata ada di dalam dictionary
            if (!dictionary.contains(start) || !dictionary.contains(goal)) {
                System.out.print("\n");
                System.out.println("*");
                System.out.println("**");
                System.out.println("Peringatan : Salah satu atau kedua kata masukkan tidak ditemukan di kamus.");
                System.out.println("**");
                System.out.println("*");
                System.out.print("\n");
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
                System.out.print("\n");
                System.out.println("*");
                System.out.println("**");
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                System.out.println("**");
                System.out.println("*");
                System.out.print("\n");
                continue;
            }

            break;
        
        } while (true);

        SearchAlgorithm searchAlgorithm = null;

        switch (choice) {
            case 1:
                searchAlgorithm = new UCS(start, goal, dictionary);
                break;
            case 2:
                searchAlgorithm = new A_Star(start, goal, dictionary);
                break;
            case 3:
                searchAlgorithm = new Greedy(start, goal, dictionary);
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
            //absolute path src
            String srcDirPath = new File("src").getAbsolutePath();

            // System.out.println(srcDirPath);
            // Mengecek apakah sistem operasi yang digunakan adalah Windows
            boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

            //Asumsi
            // Jika di Windows, maka gunakan pemisah jalur file "\\".
            // Jika di Linux atau WSL, gunakan pemisah jalur file "/".
            String fileSeparator = isWindows ? "\\" : "/";

            // Menggabungkan path src dengan nama file menggunakan pemisah yang tepat
            String fullPath = srcDirPath + fileSeparator + WORDS_FILE_PATH;

            Scanner fileScanner = new Scanner(new File(fullPath));
            while (fileScanner.hasNextLine()) {
                dictionary.add(fileScanner.nextLine().trim());
            }
            fileScanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.print("\n");
            System.out.println("*");
            System.out.println("**");
            System.out.println("File words_alpha.txt tidak ditemukan.");
            System.out.println("Tolong file words_alpha.txt nya jangan di hapus atau dipindahin ya kakak asisten yang terhormat.");
            System.out.println("Terimakasih :)");
            System.out.println("**");
            System.out.println("*");
            System.out.print("\n");
            e.printStackTrace();
            System.exit(0);
        }
        return dictionary;
    }
}
