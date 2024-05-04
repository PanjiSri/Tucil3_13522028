import java.util.ArrayList;
import java.util.List;

public class UCS extends SearchAlgorithm {

    public UCS(String word_start, String word_goal, List<String> dictionary) {
        super(word_start, word_goal, dictionary);
    }

    public void algorithm() {
        // Uniform Cost Search
        String currentWord = word_start;

        // Simpul buat di ekspan
        ArrayList<StringIntegerPair> nodeToExpan = new ArrayList<>();

        // Simpul Simpul ekspansi
        ArrayList<StringIntegerPair> nodeExpansion = new ArrayList<>();

        nodeToExpan.add(new StringIntegerPair(currentWord, 0));

        Worddiff wd = new Worddiff();

        int cost = 0;

        while (!currentWord.equals(word_goal)) {
            ArrayList<String> temp = wd.findWordDiff(currentWord, dictionary);

            for (int i = 0; i < temp.size(); i++) {
                List<String> firstWordsList = new ArrayList<>();

                // kata kata simpul yang pernah diekspan
                for (StringIntegerPair element : nodeToExpan) {
                    String[] firstWords = element.getStringElement().split(" ");
                    firstWordsList.add(firstWords[0]);
                }

                // kalau belum pernah di ekspan baru boleh jadi calon untuk di ekspan
                if (!firstWordsList.contains(temp.get(i))) {
                    StringIntegerPair newNode = new StringIntegerPair(
                            temp.get(i) + " " + nodeToExpan.get(nodeToExpan.size() - 1).getStringElement(), cost + 1);
                    insertInOrder(nodeExpansion, newNode);
                }
            }

            if (nodeExpansion.size() == 0) {
                System.out.print("\n");
                System.out.println("*");
                System.out.println("**");
                System.out.println("Tidak ada solusi menurut kamus words_alpha.txt");
                System.out.println("**");
                System.out.println("*");
                System.exit(0);
                break;
            }

            StringIntegerPair min = nodeExpansion.remove(0);
            nodeToExpan.add(min);

            currentWord = min.getStringElement().split(" ")[0];
            cost++;
        }

        //buat ngeprint hasilnya
         String path = nodeToExpan.get(nodeToExpan.size() - 1).getStringElement();

         System.out.print("\n");
         System.out.println("Solusi: ");
         System.out.println("==========");
         for (int i = path.split(" ").length - 1; i >= 0; i--) {
             System.out.println(path.split(" ")[i]);
         }
         System.out.println("==========");
    }

    public void insertInOrder(ArrayList<StringIntegerPair> list, StringIntegerPair newItem) {
        int index = 0;
        // Masuknya biar terurut
        while (index < list.size() && list.get(index).getIntegerElement() < newItem.getIntegerElement()) {
            index++;
        }
        list.add(index, newItem);
    }

    //UCS gak perlu method ini sebenernya
    public int countLetterDifference(String word1, String word2) {
        return 0;
    }
}
