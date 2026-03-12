import java.util.*;

class CancellationService {

    HashMap<String, Integer> inventory = new HashMap<>();
    HashMap<String, String> bookings = new HashMap<>();
    Stack<String> releasedRooms = new Stack<>();

    CancellationService() {
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 1);

        bookings.put("R101", "Single Room");
        bookings.put("R102", "Double Room");
    }

    void cancelBooking(String reservationId) {

        if (!bookings.containsKey(reservationId)) {
            System.out.println("Cancellation Failed: Reservation not found.");
            return;
        }

        String roomType = bookings.get(reservationId);

        releasedRooms.push(reservationId);
        inventory.put(roomType, inventory.get(roomType) + 1);
        bookings.remove(reservationId);

        System.out.println("Booking " + reservationId + " cancelled. Room released.");
    }

    void showReleasedRooms() {
        System.out.println("\nRollback Stack:");
        for (String r : releasedRooms) {
            System.out.println(r);
        }
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 10.0\n");

        CancellationService service = new CancellationService();

        service.cancelBooking("R101");
        service.cancelBooking("R999");

        service.showReleasedRooms();
    }
}