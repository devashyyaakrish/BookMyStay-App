import java.io.*;
import java.util.HashMap;

class SystemState implements Serializable {
    HashMap<String, Integer> inventory = new HashMap<>();

    SystemState() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
    }
}

public class UseCase12DataPersistenceRecovery {

    static String FILE = "hotel_state.ser";

    public static void saveState(SystemState state) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
            out.writeObject(state);
            out.close();
            System.out.println("System state saved.");
        } catch (Exception e) {
            System.out.println("Error saving state.");
        }
    }

    public static SystemState loadState() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE));
            SystemState state = (SystemState) in.readObject();
            in.close();
            System.out.println("System state restored.");
            return state;
        } catch (Exception e) {
            System.out.println("No previous state found. Starting fresh.");
            return new SystemState();
        }
    }

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 12.0\n");

        SystemState state = loadState();

        System.out.println("Current Inventory:");
        for (String room : state.inventory.keySet()) {
            System.out.println(room + ": " + state.inventory.get(room));
        }

        state.inventory.put("Single Room", state.inventory.get("Single Room") - 1);

        saveState(state);
    }
}