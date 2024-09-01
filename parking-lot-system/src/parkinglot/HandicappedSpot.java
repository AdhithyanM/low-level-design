package parkinglot;

public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(String number) {
        super(ParkingSpotType.HANDICAPPED, number);
    }
}
