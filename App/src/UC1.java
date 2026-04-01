import java.util.LinkedList;

public class TrainLinkedListSystem {
    public static void main(String[] args) {

        // Create LinkedList for train consist
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2 (index 1)
        train.add(1, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(train);

        // Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(train);

        // Final display
        System.out.println("\nFinal Train Consist:");
        System.out.println(train);
    }
}