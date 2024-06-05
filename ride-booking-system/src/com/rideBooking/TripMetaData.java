package com.rideBooking;

public class TripMetaData {
    private Location pickupLocation;
    private Location dropoffLocation;

    public TripMetaData(Location pickupLocation, Location dropoffLocation) {
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
    }

    public Location getpickupLocation() {
        return pickupLocation;
    }

    public Location getdropoffLocation() {
        return dropoffLocation;
    }
}
