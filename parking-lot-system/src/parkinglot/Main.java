package parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("MLCP");
        ParkingService parkingService = new ParkingService(parkingLot);

        ParkingSpot spot1 = new HandicappedSpot("H1");
        ParkingSpot spot2 = new CompactSpot("C1");
        ParkingSpot spot3 = new LargeSpot("L1");

        parkingService.addParkingSpot(spot1);
        parkingService.addParkingSpot(spot2);
        parkingService.addParkingSpot(spot3);

        Vehicle car1 = new Car();
        car1.setLicenseNumber("ASF13123");
        Vehicle truck1 = new Truck();
        truck1.setLicenseNumber("TRSCDV1123");

        parkingService.displayParkingSpots();

        String ticket1 = parkingService.parkVehicle(car1);
        String ticket2 = parkingService.parkVehicle(truck1);

        parkingService.displayParkingSpots();

        parkingService.unparkVehicle(ticket1);
        parkingService.unparkVehicle(ticket2);

        parkingService.displayParkingSpots();
    }
}
