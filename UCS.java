import java.util.*;


public class UCS {

    private String word_start;
    private String word_goal;

    public UCS() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word start: ");
        word_start = sc.nextLine().toLowerCase();
        System.out.print("Enter word goal: ");
        word_goal = sc.nextLine().toUpperCase();
        sc.close();
    }

    public Map<String, Integer> generatePermutationsMap(String word) {
        Map<String, Integer> permutationsMap = new HashMap<>();

        List<String> permutations = generatePermutations(word);

        for (String perm : permutations) {
            int diffCount = countDifferentLetters(perm, word_goal);
            permutationsMap.put(perm, diffCount);
        }

        return permutationsMap;
    }

    public void printWordStartGoal() {
        System.out.println("Word start: " + word_start);
        System.out.println("Word goal: " + word_goal);
    }

    public List<String> generatePermutations(String word) {
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

    public int countDifferentLetters(String word1, String word2) {

        int count = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        UCS ucs = new UCS();
        ucs.printWordStartGoal();

        // String exampleWord = "EAT"; // Contoh kata
        // Map<String, Integer> result = ucs.generatePermutationsMap(exampleWord);
        // // Menampilkan hasil
        // int i = 0;
        // for (Map.Entry<String, Integer> entry : result.entrySet()) {
        //     System.out.printf("%d. %s\n", ++i, entry.getKey() + " -> " + entry.getValue());
        // }
        // List<String> permutations = ucs.generatePermutations(exampleWord);
        // System.out.println("Kata-kata yang mungkin:");
        // int i = 0;
        // for (String perm : permutations) {
        //     System.out.printf("%d. %s\n", ++i, perm);
        // }
    }

}