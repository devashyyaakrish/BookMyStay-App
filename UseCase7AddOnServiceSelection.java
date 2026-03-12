import java.util.*;

class Service {
    String name;
    double price;

    Service(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class AddOnServiceManager {
    HashMap<String, List<Service>> serviceMap = new HashMap<>();

    void addService(String reservationId, Service service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);
    }

    double getTotalCost(String reservationId) {
        double total = 0;
        List<Service> services = serviceMap.get(reservationId);
        if (services != null) {
            for (Service s : services) {
                total += s.price;
            }
        }
        return total;
    }

    void showServices(String reservationId) {
        List<Service> services = serviceMap.get(reservationId);
        if (services != null) {
            for (Service s : services) {
                System.out.println(s.name + " - $" + s.price);
            }
        }
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Version 7.0\n");

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "R101";

        manager.addService(reservationId, new Service("Breakfast", 20));
        manager.addService(reservationId, new Service("Airport Pickup", 40));
        manager.addService(reservationId, new Service("Spa Access", 30));

        System.out.println("Services for Reservation " + reservationId + ":\n");
        manager.showServices(reservationId);

        System.out.println("\nTotal Add-On Cost: $" + manager.getTotalCost(reservationId));
    }
}