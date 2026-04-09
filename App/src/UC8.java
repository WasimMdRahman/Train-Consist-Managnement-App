import java.util.*;
import java.util.stream.*;

class Bogie {
    int id;
    int capacity;

    Bogie(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return "Bogie ID: " + id + ", Capacity: " + capacity;
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie(1, 50),
                new Bogie(2, 65),
                new Bogie(3, 70),
                new Bogie(4, 55)
        );

        // Stream filtering
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // Display result
        System.out.println("Filtered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);
    }
}