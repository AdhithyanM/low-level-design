package parkinglot;

public abstract class ParkingSpot {
    private String number;
    private final ParkingSpotType type;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(ParkingSpotType type, String number) {
        this.type = type;
        this.number = number;
        isFree = true;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public boolean isFree() {
        return isFree;
    }

    public void park(Vehicle vehicle) {
        vehicle = vehicle;
        isFree = false;
    }

    public void unpark() {
        vehicle = null;
        isFree = true;
    }
}
