import java.util.Scanner;

public class BogieLinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of bogies
        System.out.print("Enter number of bogies: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieIDs = new String[n];

        // Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIDs[i] = sc.nextLine();
        }

        // Search key
        System.out.print("\nEnter bogie ID to search: ");
        String key = sc.nextLine();

        // Linear Search
        boolean found = false;
        int position = -1;

        for (int i = 0; i < n; i++) {

            if (bogieIDs[i].equals(key)) {
                found = true;
                position = i;
                break; // early termination
            }
        }

        // Result display
        System.out.println("\nSEARCH RESULT:");

        if (found) {
            System.out.println("Bogie ID FOUND at position: " + position);
        } else {
            System.out.println("Bogie ID NOT FOUND in the list.");
        }

        System.out.println("\nProgram completed successfully.");

        sc.close();
    }
}