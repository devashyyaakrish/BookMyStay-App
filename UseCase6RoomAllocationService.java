import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class InventoryService {
    HashMap<String, Integer> inventory = new HashMap<>();

    InventoryService() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    int getAvailability(String room) {
        return inventory.getOrDefault(room, 0);
    }

    void decrease(String room) {
        inventory.put(room, inventory.get(room) - 1);
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 6.0\n");

        Queue<Reservation> queue = new LinkedList<>();
        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Double Room"));
        queue.add(new Reservation("Charlie", "Single Room"));

        InventoryService inventory = new InventoryService();

        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();
        int roomCounter = 1;

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();

            if (inventory.getAvailability(r.roomType) > 0) {

                String roomId = r.roomType.replace(" ", "") + roomCounter++;
                allocatedRooms.putIfAbsent(r.roomType, new HashSet<>());
                allocatedRooms.get(r.roomType).add(roomId);

                inventory.decrease(r.roomType);

                System.out.println("Reservation Confirmed: " + r.guestName +
                        " -> " + r.roomType + " | Room ID: " + roomId);

            } else {
                System.out.println("No rooms available for " + r.guestName +
                        " (" + r.roomType + ")");
            }
        }
    }
}