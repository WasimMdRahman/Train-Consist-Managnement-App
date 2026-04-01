import java.util.HashSet;

public class UniqueBogieSystem {
    public static void main(String[] args) {

        // Create HashSet for bogie IDs
        HashSet<Integer> bogieIds = new HashSet<>();

        // Add bogie IDs
        System.out.println("Adding Bogie IDs...");

        addBogie(bogieIds, 101);
        addBogie(bogieIds, 102);
        addBogie(bogieIds, 103);

        // Attempt to add duplicate
        addBogie(bogieIds, 102);

        // Display unique bogie IDs
        System.out.println("\nFinal Unique Bogie IDs:");
        System.out.println(bogieIds);
    }

    // Method to add bogie with duplicate check
    public static void addBogie(HashSet<Integer> set, int id) {
        if (set.add(id)) {
            System.out.println("Bogie ID " + id + " added successfully.");
        } else {
            System.out.println("Duplicate Bogie ID " + id + " ignored!");
        }
    }
}