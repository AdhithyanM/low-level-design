package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name;
    private Map<String, ParkingSpot> parkingSpots;
    private Map<String, ParkingTicket> tickets;

    public ParkingLot(String name) {
        this.name = name;
        parkingSpots = new HashMap<>();
        tickets = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<String, ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Map<String, ParkingTicket> getTickets() {
        return tickets;
    }

    public void setTickets(Map<String, ParkingTicket> tickets) {
        this.tickets = tickets;
    }
}
