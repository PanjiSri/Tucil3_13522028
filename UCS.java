import java.util.*;

public class UCS{

    private String word_start;
    private String word_goal;

    public UCS(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word start: ");
        word_start = sc.nextLine().toLowerCase(); 
        System.out.print("Enter word goal: ");
        word_goal = sc.nextLine().toUpperCase(); 
        sc.close();
    }

    

    public void printWordStartGoal(){
        System.out.println("Word start: " + word_start);
        System.out.println("Word goal: " + word_goal);
    }

    public static void main(String[] args){
        UCS ucs = new UCS();
        ucs.printWordStartGoal();
    }

}