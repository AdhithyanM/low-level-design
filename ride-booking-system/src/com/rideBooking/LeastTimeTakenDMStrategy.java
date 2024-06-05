package com.rideBooking;

import java.util.List;

public class LeastTimeTakenDMStrategy implements DriverMatchingStrategy{
    private DriverManager driverManager;

    public LeastTimeTakenDMStrategy() {
        driverManager = DriverManager.getInstance();
    }

    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        List<Driver> availableDrivers = driverManager.getAvailableDrivers(tripMetaData.getpickupLocation());

        if(availableDrivers.isEmpty()) {
            return null; // no drivers available
        }

        // Implement custom algorithm here.
        Driver bestDriver = availableDrivers.get(0);
        return bestDriver;
    }
}
