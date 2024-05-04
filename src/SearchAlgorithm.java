import java.util.Scanner;
import java.util.ArrayList;

public abstract class SearchAlgorithm {
    protected String word_start;
    protected String word_goal;

    public SearchAlgorithm(String word_start, String word_goal) {
        this.word_start = word_start.toLowerCase();
        this.word_goal = word_goal.toLowerCase();
    }

    public void printWordStartGoal() {
        System.out.println("Kata Mulai: " + word_start.toUpperCase());
        System.out.println("Kata Tujuan: " + word_goal.toUpperCase());
    }   

    public abstract void algorithm();

    public abstract void insertInOrder(ArrayList<StringIntegerPair> list, StringIntegerPair newItem);
    public abstract int countLetterDifference(String word1, String word2);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word start: ");
        String start = sc.nextLine().toUpperCase();
        System.out.print("Enter word goal: ");
        String goal = sc.nextLine().toUpperCase();
        sc.close();

        SearchAlgorithm searchAlgorithm = new UCS(start, goal); // Anda bisa mengganti dengan A_Star atau Greedy
        searchAlgorithm.printWordStartGoal();
        System.out.println("Testing algorithm");
        searchAlgorithm.algorithm();
    }
}
