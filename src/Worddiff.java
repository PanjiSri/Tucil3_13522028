import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Worddiff {
    // public static void main(String[] args) {

    //     ArrayList<String> result = findWordDiff("Fire");

    //     System.out.println("Kata-kata dengan perbedaan satu huruf dari input: ");
    //     for (String word : result) {
    //         System.out.println(word);
    //     }
    // }

    public ArrayList<String> findWordDiff(String kata) {
        ArrayList<String> hasil = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words_alpha.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (isDiffOneLetter(kata, line.trim())) {
                    hasil.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hasil;
    }

    // Method untuk memeriksa apakah dua kata memiliki perbedaan satu huruf
    private boolean isDiffOneLetter(String kata1, String kata2) {
        if (kata1.length() != kata2.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < kata1.length(); i++) {
            if (kata1.charAt(i) != kata2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }
}
