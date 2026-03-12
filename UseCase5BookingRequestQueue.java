import java.util.LinkedList;
import java.util.Queue;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println(guestName + " requested " + roomType);
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 5.0\n");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Double Room"));
        bookingQueue.add(new Reservation("Charlie", "Suite Room"));

        System.out.println("Booking Requests in Queue:\n");

        for (Reservation r : bookingQueue) {
            r.display();
        }
    }
}