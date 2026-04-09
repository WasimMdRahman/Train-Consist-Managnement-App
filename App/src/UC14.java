// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    int id;
    int capacity;

    PassengerBogie(int id, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0");
        }
        this.id = id;
        this.capacity = capacity;
    }

    public String toString() {
        return "Bogie ID: " + id + ", Capacity: " + capacity;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie(1, 60);
            System.out.println(b1);

            // Invalid case
            PassengerBogie b2 = new PassengerBogie(2, -10);
            System.out.println(b2);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}