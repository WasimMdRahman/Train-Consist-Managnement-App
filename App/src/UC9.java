import java.util.*;
import java.util.stream.*;

class Bogie {
    int id;
    String type;
    int capacity;

    Bogie(int id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Bogie ID: " + id + ", Type: " + type + ", Capacity: " + capacity;
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating bogie list
        List<Bogie> bogies = Arrays.asList(
                new Bogie(1, "Sleeper", 72),
                new Bogie(2, "AC", 60),
                new Bogie(3, "Sleeper", 70),
                new Bogie(4, "General", 90),
                new Bogie(5, "AC", 65)
        );

        // Grouping using Stream API
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.getType()));

        // Display grouped result
        System.out.println("Grouped Bogies:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("\nType: " + type);
            list.forEach(System.out::println);
        });
    }
}