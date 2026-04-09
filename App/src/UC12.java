import java.util.*;
import java.util.function.Predicate;

class GoodsBogie {
    int id;
    String type;
    String cargo;

    GoodsBogie(int id, String type, String cargo) {
        this.id = id;
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public String toString() {
        return "Bogie ID: " + id + ", Type: " + type + ", Cargo: " + cargo;
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating goods bogie list
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie(1, "Cylindrical", "Petroleum"),
                new GoodsBogie(2, "Box", "Coal"),
                new GoodsBogie(3, "Cylindrical", "Petroleum"),
                new GoodsBogie(4, "Flat", "Steel")
        );

        // Functional interface (Predicate)
        Predicate<GoodsBogie> safetyRule = b ->
                !b.getType().equalsIgnoreCase("Cylindrical") ||
                        b.getCargo().equalsIgnoreCase("Petroleum");

        // Validate using allMatch
        boolean isSafe = bogies.stream()
                .allMatch(safetyRule);

        // Display result
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }
    }
}