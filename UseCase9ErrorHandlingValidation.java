import java.util.HashMap;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

class BookingValidator {

    HashMap<String, Integer> inventory = new HashMap<>();

    BookingValidator() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 0);
    }

    void validateBooking(String roomType) throws InvalidBookingException {

        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for " + roomType);
        }

        System.out.println("Booking validated successfully for " + roomType);
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 9.0\n");

        BookingValidator validator = new BookingValidator();

        try {
            validator.validateBooking("Suite Room");
        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }

        try {
            validator.validateBooking("Luxury Room");
        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }

        try {
            validator.validateBooking("Single Room");
        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
    }
}