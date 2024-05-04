import java.util.ArrayList;
import java.util.List;

public abstract class SearchAlgorithm {
    protected String word_start;
    protected String word_goal;
    protected List<String> dictionary;

    public SearchAlgorithm(String word_start, String word_goal, List<String> dictionary) {
        this.word_start = word_start.toLowerCase();
        this.word_goal = word_goal.toLowerCase();
        this.dictionary = dictionary;
    }

    public void printWordStartGoal() {
        System.out.println("Kata Mulai: " + word_start.toUpperCase());
        System.out.println("Kata Tujuan: " + word_goal.toUpperCase());
    }

    public abstract void algorithm();

    public abstract void insertInOrder(ArrayList<StringIntegerPair> list, StringIntegerPair newItem);

    public abstract int countLetterDifference(String word1, String word2);
}
