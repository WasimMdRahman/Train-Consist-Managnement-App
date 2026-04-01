import java.util.*;

// Coach class
class Coach {
    int id;
    String type;

    Coach prev, next;

    public Coach(int id, String type) {
        this.id = id;
        this.type = type;
        this.prev = null;
        this.next = null;
    }

    public String toString() {
        return "[" + id + " - " + type + "]";
    }
}

// Doubly Linked List for Train Consist
class TrainConsist {
    private Coach head;
    private Coach tail;
    private Set<Integer> coachIds = new HashSet<>();

    // Add coach at end
    public void addCoach(int id, String type) {
        if (coachIds.contains(id)) {
            System.out.println("Duplicate coach ID not allowed!");
            return;
        }

        Coach newCoach = new Coach(id, type);
        coachIds.add(id);

        if (head == null) {
            head = tail = newCoach;
        } else {
            tail.next = newCoach;
            newCoach.prev = tail;
            tail = newCoach;
        }
        System.out.println("Coach added.");
    }

    // Insert at position
    public void insertAtPosition(int pos, int id, String type) {
        if (coachIds.contains(id)) {
            System.out.println("Duplicate coach ID not allowed!");
            return;
        }

        Coach newCoach = new Coach(id, type);
        coachIds.add(id);

        if (pos == 1) {
            newCoach.next = head;
            if (head != null) head.prev = newCoach;
            head = newCoach;
            if (tail == null) tail = newCoach;
            return;
        }

        Coach temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newCoach.next = temp.next;
        if (temp.next != null) temp.next.prev = newCoach;
        temp.next = newCoach;
        newCoach.prev = temp;

        if (newCoach.next == null) tail = newCoach;
    }

    // Remove coach by ID
    public void removeCoach(int id) {
        Coach temp = head;

        while (temp != null) {
            if (temp.id == id) {
                coachIds.remove(id);

                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;

                System.out.println("Coach removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Coach not found.");
    }

    // Reverse consist
    public void reverse() {
        Coach current = head;
        Coach temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        System.out.println("Train reversed.");
    }

    // Display
    public void display() {
        Coach temp = head;
        if (temp == null) {
            System.out.println("Train is empty.");
            return;
        }

        while (temp != null) {
            System.out.print(temp + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Stack for Undo
class UndoStack {
    Stack<Runnable> stack = new Stack<>();

    public void push(Runnable action) {
        stack.push(action);
    }

    public void undo() {
        if (!stack.isEmpty()) {
            stack.pop().run();
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}

// Main Application
public class TrainManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrainConsist train = new TrainConsist();
        UndoStack undoStack = new UndoStack();

        while (true) {
            System.out.println("\n1. Add Coach");
            System.out.println("2. Insert Coach at Position");
            System.out.println("3. Remove Coach");
            System.out.println("4. Reverse Train");
            System.out.println("5. Display Train");
            System.out.println("6. Undo");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID and Type: ");
                    int id = sc.nextInt();
                    String type = sc.next();
                    train.addCoach(id, type);
                    break;

                case 2:
                    System.out.print("Enter position, ID and Type: ");
                    int pos = sc.nextInt();
                    int id2 = sc.nextInt();
                    String type2 = sc.next();
                    train.insertAtPosition(pos, id2, type2);
                    break;

                case 3:
                    System.out.print("Enter ID to remove: ");
                    int rid = sc.nextInt();
                    train.removeCoach(rid);
                    break;

                case 4:
                    train.reverse();
                    break;

                case 5:
                    train.display();
                    break;

                case 6:
                    undoStack.undo();
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
