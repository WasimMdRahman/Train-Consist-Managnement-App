import java.util.Arrays;
import java.util.Scanner;

public class BogieTypeSorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of bogie types
        System.out.print("Enter number of bogie types: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieTypes = new String[n];

        // Input bogie type names
        System.out.println("Enter bogie type names:");
        for (int i = 0; i < n; i++) {
            bogieTypes[i] = sc.nextLine();
        }

        // Before sorting
        System.out.println("\nBefore Sorting:");
        System.out.println(Arrays.toString(bogieTypes));

        // Sorting using built-in method
        Arrays.sort(bogieTypes);

        // After sorting
        System.out.println("\nAfter Sorting (Alphabetical Order):");
        System.out.println(Arrays.toString(bogieTypes));

        System.out.println("\nProgram completed successfully.");

        sc.close();
    }
}