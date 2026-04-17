import java.util.Arrays;
import java.util.Scanner;

public class BogieBinarySearch {

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

        // IMPORTANT: Binary search requires sorted data
        Arrays.sort(bogieIDs);

        System.out.println("\nSorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIDs));

        // Search key
        System.out.print("\nEnter bogie ID to search: ");
        String key = sc.nextLine();

        // Binary Search logic
        int low = 0;
        int high = n - 1;
        boolean found = false;
        int position = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = bogieIDs[mid].compareTo(key);

            if (result == 0) {
                found = true;
                position = mid;
                break;
            }
            else if (result < 0) {
                low = mid + 1;   // search right half
            }
            else {
                high = mid - 1;  // search left half
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