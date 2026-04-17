// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Enum for Cargo Types
enum CargoType {
    PETROLEUM,
    FOOD,
    COAL,
    GENERAL
}

// Enum for Bogie Shapes
enum BogieShape {
    RECTANGULAR,
    CYLINDRICAL
}

// Bogie class
class GoodsBogie {
    private int id;
    private BogieShape shape;
    private CargoType cargo;

    public GoodsBogie(int id, BogieShape shape) {
        this.id = id;
        this.shape = shape;
    }

    // Assignment method with safety check
    public void assignCargo(CargoType cargo) {
        try {
            System.out.println("Attempting to assign " + cargo + " to Bogie " + id);

            // Safety validation rule
            if (this.shape == BogieShape.RECTANGULAR && cargo == CargoType.PETROLEUM) {
                throw new CargoSafetyException(
                        "UNSAFE OPERATION: Petroleum cannot be assigned to RECTANGULAR bogie (Bogie ID: " + id + ")"
                );
            }

            this.cargo = cargo;
            System.out.println("SUCCESS: Cargo assigned successfully to Bogie " + id);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("LOG: Assignment attempt completed for Bogie " + id);
            System.out.println("--------------------------------------");
        }
    }

    public void displayStatus() {
        System.out.println("Bogie ID: " + id +
                ", Shape: " + shape +
                ", Cargo: " + (cargo != null ? cargo : "EMPTY"));
    }
}

// Main class
public class TrainConsistApp {
    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie(101, BogieShape.RECTANGULAR);
        GoodsBogie b2 = new GoodsBogie(102, BogieShape.CYLINDRICAL);

        // Case 1: Unsafe assignment (should throw exception)
        b1.assignCargo(CargoType.PETROLEUM);

        // Case 2: Safe assignment
        b2.assignCargo(CargoType.PETROLEUM);

        // Case 3: Another safe assignment
        b1.assignCargo(CargoType.FOOD);

        // System continues normally
        System.out.println("\nFinal Status:");
        b1.displayStatus();
        b2.displayStatus();
    }
}