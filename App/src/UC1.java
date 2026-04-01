import java.util.*;

// Custom Bogie class
class Bogie {
    String name;
    int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Display format
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class BogieSortingSystem {
    public static void main(String[] args) {

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Before Sorting:");
        display(bogies);

        // Sort using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        display(bogies);
    }

    // Display method
    public static void display(List<Bogie> bogies) {
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}