import java.util.Scanner;

public class TrainSearchSafety {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogies = new String[n];

        // Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogies[i] = sc.nextLine();
        }

        // SEARCH OPERATION TRIGGER
        System.out.print("\nEnter bogie ID to search: ");
        String key = sc.nextLine();

        try {
            searchBogie(bogies, key);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");

        sc.close();
    }

    // Search method with defensive programming
    public static void searchBogie(String[] bogies, String key) {

        // STATE VALIDATION (IMPORTANT)
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException(
                    "Search operation failed: Train has no bogies (empty state)."
            );
        }

        boolean found = false;

        for (int i = 0; i < bogies.length; i++) {

            if (bogies[i].equals(key)) {
                System.out.println("\nRESULT: Bogie FOUND at position " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nRESULT: Bogie NOT FOUND in the train.");
        }
    }
}