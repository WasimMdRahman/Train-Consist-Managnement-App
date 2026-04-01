import java.util.LinkedHashSet;

public class TrainLinkedHashSetSystem {
    public static void main(String[] args) {

        // Create LinkedHashSet for train formation
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Add bogies
        System.out.println("Adding bogies...");

        addBogie(train, "Engine");
        addBogie(train, "Sleeper");
        addBogie(train, "Cargo");
        addBogie(train, "Guard");

        // Attempt duplicate
        addBogie(train, "Sleeper");

        // Display final formation
        System.out.println("\nFinal Train Formation (Order Preserved):");
        System.out.println(train);
    }

    // Method to handle insertion
    public static void addBogie(LinkedHashSet<String> set, String bogie) {
        if (set.add(bogie)) {
            System.out.println(bogie + " added successfully.");
        } else {
            System.out.println("Duplicate bogie '" + bogie + "' ignored!");
        }
    }
}