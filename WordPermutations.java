import java.util.ArrayList;
import java.util.List;

public class WordPermutations {
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Masukkan kata: ");
    //     String inputWord = scanner.nextLine().toUpperCase(); 

    //     List<String> permutations = generatePermutations(inputWord);

    //     System.out.println("Kata-kata yang mungkin:");
    //     for (String word : permutations) {
    //         System.out.println(word);
    //     }

    //     scanner.close();
    // }

    public static List<String> generatePermutations(String word) {
        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                if (c != word.charAt(i)) {
                    StringBuilder newWord = new StringBuilder(word);
                    newWord.setCharAt(i, c);
                    permutations.add(newWord.toString());
                }
            }
        }

        return permutations;
    }
}
