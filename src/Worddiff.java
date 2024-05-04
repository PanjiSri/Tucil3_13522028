import java.util.ArrayList;
import java.util.List;

public class Worddiff {
    public ArrayList<String> findWordDiff(String word, List<String> dictionary) {
        ArrayList<String> result = new ArrayList<>();

        for (String entry : dictionary) {
            if (isOneLetterDifferent(word, entry)) {
                result.add(entry);
            }
        }

        return result;
    }

    private boolean isOneLetterDifferent(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }
}
