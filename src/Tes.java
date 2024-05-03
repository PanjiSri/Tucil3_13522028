import java.util.ArrayList;

public class Tes {
 public static void main(String[] args) {
        // Membuat ArrayList of String
        ArrayList<String> myList = new ArrayList<>();

        // Menambahkan elemen ke ArrayList
        myList.add("Elemen 1");
        myList.add("Elemen 2");
        myList.add("Elemen 3");

        // Melakukan print list
        System.out.println("ArrayList sebelum penghapusan:");
        printList(myList);

        // Menghapus elemen ke-0
        if (!myList.isEmpty()) {
            myList.remove(0);
        }

        // Melakukan print lagi setelah penghapusan
        System.out.println("\nArrayList setelah penghapusan:");
        printList(myList);

        System.out.println("Indeks ke 0 sekarang: ");
        System.out.println(myList.get(0));
    }

    // Method untuk melakukan print list
    public static void printList(ArrayList<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }   
}
