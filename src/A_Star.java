import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_Star extends SearchAlgorithm {

    public A_Star(String word_start, String word_goal) {
        super(word_start, word_goal);
    }

    public void algorithm() {
        // A* Search
        String currentWord = word_start;

        // Nodes to expand
        ArrayList<StringIntegerPair> nodeToExpand = new ArrayList<>();

        // Expanded nodes
        ArrayList<StringIntegerPair> nodeExpansion = new ArrayList<>();

        nodeToExpand.add(new StringIntegerPair(currentWord, 0));

        Worddiff wd = new Worddiff();

        int cost = 0;

        while (!currentWord.equals(word_goal)) {
            ArrayList<String> temp = wd.findWordDiff(currentWord);

            for (int i = 0; i < temp.size(); i++) {
                List<String> firstWordsList = new ArrayList<>();

                // kata kata simpul yang pernah diekspan
                for (StringIntegerPair element : nodeToExpand) {
                    String[] firstWords = element.getStringElement().split(" ");
                    firstWordsList.add(firstWords[0]);
                }

                // kalau belum pernah di ekspan baru boleh jadi calon untuk di ekspan
                if (!firstWordsList.contains(temp.get(i))) {

                    int heuristic = countLetterDifference(temp.get(i), word_goal);

                    StringIntegerPair newNode = new StringIntegerPair(
                            temp.get(i) + " " + nodeToExpand.get(nodeToExpand.size() - 1).getStringElement(),
                            heuristic + cost);
                    insertInOrder(nodeExpansion, newNode);
                }
            }

            StringIntegerPair min = nodeExpansion.remove(0);
            nodeToExpand.add(min);

            currentWord = min.getStringElement().split(" ")[0];
            cost++;
        }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word start: ");
        String start = sc.nextLine().toUpperCase();
        System.out.print("Enter word goal: ");
        String goal = sc.nextLine().toUpperCase();
        sc.close();

        A_Star aStar = new A_Star(start, goal);
        aStar.printWordStartGoal();
        System.out.println("Testing algorithm");
        aStar.algorithm();
    }
}
