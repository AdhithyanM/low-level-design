package com.rideBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverManager {
    private static DriverManager instance;
    private Map<String, Driver> drivers;

    private DriverManager() {
        drivers = new HashMap<>();
    }

    public static DriverManager getInstance() {
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public Driver getDriver(String id) {
        return drivers.get(id);
    }

    public List<Driver> getAvailableDrivers(Location location) {
        // TO DO: implement logic to fetch drivers based on location.
        List<Driver> availableDrivers = new ArrayList<>();
        for(Driver driver : drivers.values()) {
            if(driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }
}
