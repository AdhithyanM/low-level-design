package parkinglot;

import Vehicle;
import VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingService {
    private ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public boolean addParkingSpot(ParkingSpot spot) {
        Map<String, ParkingSpot> parkingSpots = parkingLot.getParkingSpots();
        if(parkingSpots.containsKey(spot.getNumber())) {
            return false;
        }
        parkingSpots.put(spot.getNumber(), spot);
        return true;
    }

    public boolean removeParkingSpot(String spotNumber) {
        Map<String, ParkingSpot> parkingSpots = parkingLot.getParkingSpots();
        if(parkingSpots.containsKey(spotNumber) && parkingSpots.get(spotNumber).isFree()) {
            parkingSpots.remove(spotNumber);
            return true;
        }
        return false;
    }

    public String parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if(spot == null) {
            return null;
        }
        spot.park(vehicle);
        ParkingTicket ticket = new ParkingTicket(generateTicket(), spot, vehicle);
        parkingLot.getTickets().put(ticket.getTicketNumber(), ticket);
        return ticket.getTicketNumber();
    }

    public boolean unparkVehicle(String ticketNumber) {
        ParkingTicket ticket = parkingLot.getTickets().get(ticketNumber);
        if(ticket == null) {
            return false;
        }
        ticket.getParkingSpot().unpark();
        parkingLot.getTickets().remove(ticketNumber);
        return true;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        // we shouldn't allocate a car in large spotType and a truck in a compact spotType.
        Map<ParkingSpotType, List<ParkingSpot>> map = new HashMap<>();
        for(ParkingSpotType spotType : ParkingSpotType.values()) {
            map.put(spotType, new ArrayList<>());
        }

        for(ParkingSpot spot: parkingLot.getParkingSpots().values()) {
            if(spot.isFree()) {
                map.get(spot.getType()).add(spot);
            }
        }

        ParkingSpotType suitableSpotType = findSpotType(vehicleType);
        if(map.get(suitableSpotType).size() > 0) {
            return map.get(suitableSpotType).get(0);
        }

        return null;
    }

    private ParkingSpotType findSpotType(VehicleType vehicleType) {
        switch(vehicleType) {
            case MOTORCYCLE:
                return ParkingSpotType.HANDICAPPED;
            case CAR:
                return ParkingSpotType.COMPACT;
            case TRUCK:
                return ParkingSpotType.LARGE;
        }
        return ParkingSpotType.LARGE;
    }

    private String generateTicket() {
        return "TICKET-"+Math.random();
    }

    public void displayParkingSpots() {
        Map<ParkingSpotType, Integer> map = new HashMap<>();
        for(ParkingSpotType spotType : ParkingSpotType.values()) {
            map.put(spotType, 0);
        }
        for(ParkingSpot spot : parkingLot.getParkingSpots().values()) {
            if(spot.isFree()) {
                map.put(spot.getType(), map.get(spot.getType()) + 1);
            }
        }
        System.out.println("Available Spots: ");
        for(Map.Entry<ParkingSpotType, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
