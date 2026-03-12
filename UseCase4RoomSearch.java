import java.util.HashMap;

class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void display(int available) {
        System.out.println(type + " | Price: $" + price + " | Available: " + available);
    }
}

class RoomInventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    RoomInventory() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String room) {
        return inventory.get(room);
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 4.0\n");

        RoomInventory inv = new RoomInventory();

        Room r1 = new Room("Single Room", 1000);
        Room r2 = new Room("Double Room", 2000);
        Room r3 = new Room("Suite Room", 5000);

        Room[] rooms = {r1, r2, r3};

        for (Room r : rooms) {
            int available = inv.getAvailability(r.type);
            if (available > 0) {
                r.display(available);
            }
        }
    }
}