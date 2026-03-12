import java.util.HashMap;

class RoomInventory {

    HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    void showInventory() {
        for (String room : inventory.keySet()) {
            System.out.println(room + " Available: " + inventory.get(room));
        }
    }

    void updateRoom(String room, int count) {
        inventory.put(room, count);
    }

    int getAvailability(String room) {
        return inventory.get(room);
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 3.1\n");

        RoomInventory inv = new RoomInventory();

        inv.showInventory();

        System.out.println("\nUpdating Double Room availability...\n");

        inv.updateRoom("Double Room", 4);

        inv.showInventory();
    }
}