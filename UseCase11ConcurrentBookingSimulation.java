import java.util.*;

class Inventory {
    int rooms = 2;

    synchronized void bookRoom(String guest) {
        if (rooms > 0) {
            System.out.println(guest + " booked a room.");
            rooms--;
        } else {
            System.out.println("No rooms available for " + guest);
        }
    }
}

class BookingThread extends Thread {
    Inventory inventory;
    String guestName;

    BookingThread(Inventory inventory, String guestName) {
        this.inventory = inventory;
        this.guestName = guestName;
    }

    public void run() {
        inventory.bookRoom(guestName);
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 11.0\n");

        Inventory inventory = new Inventory();

        Thread t1 = new BookingThread(inventory, "Alice");
        Thread t2 = new BookingThread(inventory, "Bob");
        Thread t3 = new BookingThread(inventory, "Charlie");

        t1.start();
        t2.start();
        t3.start();
    }
}