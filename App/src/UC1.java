import java.util.HashMap;
import java.util.Map;

public class BogieCapacitySystem {
    public static void main(String[] args) {

        // Create HashMap for bogie-capacity mapping
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        // Insert bogie capacities
        System.out.println("Adding bogie capacities...");

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 78);
        bogieCapacity.put("First Class", 24);

        // Display all bogie capacities using entrySet()
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // Example: Fast lookup
        System.out.println("\nCapacity of Sleeper: " +
                bogieCapacity.get("Sleeper"));
    }
}