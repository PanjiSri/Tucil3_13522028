import java.util.ArrayList;
import java.util.List;

public class Greedy extends SearchAlgorithm {

    public Greedy(String word_start, String word_goal, List<String> dictionary) {
        super(word_start, word_goal, dictionary);
    }

    public void algorithm() {
        // Greedy Best First Search
        String currentWord = word_start;

        // Simpul buat di ekspan
        ArrayList<StringIntegerPair> nodeToExpand = new ArrayList<>();

        // Simpul Simpul ekspansi
        ArrayList<StringIntegerPair> nodeExpansion = new ArrayList<>();

        nodeToExpand.add(new StringIntegerPair(currentWord, 0));

        Worddiff wd = new Worddiff();

        int heuristic = 0;

        while (!currentWord.equals(word_goal)) {
            ArrayList<String> temp = wd.findWordDiff(currentWord, dictionary);

            for (int i = 0; i < temp.size(); i++) {
                List<String> firstWordsList = new ArrayList<>();

                // kata kata simpul yang pernah diekspan
                for (StringIntegerPair element : nodeToExpand) {
                    String[] firstWords = element.getStringElement().split(" ");
                    firstWordsList.add(firstWords[0]);
                }

                // kalau belum pernah di ekspan baru boleh jadi calon untuk di ekspan
                if (!firstWordsList.contains(temp.get(i))) {
                    //ini nilai heuristic nya, yaitu kata ini sama goal itu beda berapa huruf
                    heuristic = countLetterDifference(temp.get(i), word_goal);

                    StringIntegerPair newNode = new StringIntegerPair(
                            temp.get(i) + " " + nodeToExpand.get(nodeToExpand.size() - 1).getStringElement(), heuristic);
                    insertInOrder(nodeExpansion, newNode);
                }
            }

            StringIntegerPair min = nodeExpansion.remove(0);
            nodeToExpand.add(min);

            currentWord = min.getStringElement().split(" ")[0];
        }

        //buat ngeprint hasilnya
        String path = nodeToExpand.get(nodeToExpand.size() - 1).getStringElement();

        for (int i = path.split(" ").length - 1; i >= 0; i--) {
            System.out.println(path.split(" ")[i]);
        }
    }


    public void insertInOrder(ArrayList<StringIntegerPair> list, StringIntegerPair newItem) {
        int index = 0;
        // Masuknya biar terurut
        while (index < list.size() && list.get(index).getIntegerElement() < newItem.getIntegerElement()) {
            index++;
        }
        list.add(index, newItem);
    }

    public int countLetterDifference(String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
            }
        }
        return difference;
    }

}
