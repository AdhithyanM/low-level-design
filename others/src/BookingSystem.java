import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSystem {
    // tracks flights in a fashion where key represents origin and values represent destinations that can be reached from that origin
    Map<String, List<String>> map;

    public BookingSystem() {
        map = new HashMap<>();
    }

    // add a flight
    public void addFlight(String code, String origin, String destination) {
        map.putIfAbsent(origin, new ArrayList<>());
        List<String> originRoutes = map.get(origin);
        if(!originRoutes.contains(destination)) {
            originRoutes.add(destination);
        }
        // if its a 2 way graph
        map.putIfAbsent(destination, new ArrayList<>());
        List<String> destinationRoutes = map.get(destination);
        if(!destinationRoutes.contains(origin)) {
            destinationRoutes.add(origin);
        }
    }

    // determineFlight
    public boolean determineFlight(String origin, String destination) {
        if(!map.containsKey(origin)) return false;
        List<String> routes = map.get(origin);
        if(!routes.contains(destination)) return false;
        return true;
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.addFlight("A1100", "ABC", "DEF");
        bookingSystem.addFlight("A1131", "ABC", "HIJ");
        bookingSystem.addFlight("A1242", "ABC", "LMN");
        bookingSystem.addFlight("B1213", "IN", "US");

//        System.out.println(bookingSystem.map);

        System.out.println(bookingSystem.determineFlight("ABC", "LMN")); // true
        System.out.println(bookingSystem.determineFlight("IN", "US")); // true
        System.out.println(bookingSystem.determineFlight("IN", "UK")); // false
        System.out.println(bookingSystem.determineFlight("LMN", "ABC")); // true
    }
}
