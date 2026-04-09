import java.util.*;

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
}

public class Main {
    public static void main(String[] args) {

        // Creating bogie list
        List<Bogie> bogies = Arrays.asList(
                new Bogie(1, 50),
                new Bogie(2, 65),
                new Bogie(3, 70),
                new Bogie(4, 55)
        );

        // Aggregating total capacity
        int totalCapacity = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        // Display result
        System.out.println("Total Seating Capacity: " + totalCapacity);
    }
}