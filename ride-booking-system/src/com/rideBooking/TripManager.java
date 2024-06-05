package com.rideBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripManager {
    private static TripManager instance;
    private Map<String, Trip> trips;

    private TripManager() {
        trips = new HashMap<>();
    };

    public static TripManager getInstance() {
        if(instance == null) {
            instance = new TripManager();
        }
        return instance;
    }

    public Trip createTrip(Rider rider, Location pickupLocation, Location dropoffLocation) {
        StrategyManager strategyManager = StrategyManager.getInstance();

        TripMetaData tripMetaData = new TripMetaData(pickupLocation, dropoffLocation);

        DriverMatchingStrategy driverMatchingStrategy = strategyManager.getDriverMatchingStrategy(tripMetaData);

        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);
        if(driver == null) {
            return null;
        }

        PricingStrategy pricingStrategy = strategyManager.getPricingStrategy(tripMetaData);
        double price = pricingStrategy.calculatePrice(tripMetaData);

        Trip trip = new Trip(rider, driver, price, pickupLocation, dropoffLocation, driverMatchingStrategy, pricingStrategy);
        trips.put(trip.getId(), trip);

        return trip;
    }

    public List<Trip> getAllTrips() {
        return new ArrayList<>(trips.values());
    }
}
