package com.rideBooking;

import java.util.UUID;

public class Trip {
//    private static int idCounter = 0;
    private String id;
    private Rider rider;
    private Driver driver;
    private double price;
    private Location pickupLocation;
    private Location dropoffLocation;
    private DriverMatchingStrategy driverMatchingStrategy;
    private PricingStrategy pricingStrategy;

    private TripStatus status;

    public Trip(Rider rider, Driver driver, double price, Location pickupLocation, Location dropoffLocation, DriverMatchingStrategy driverMatchingStrategy, PricingStrategy pricingStrategy) {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.driver = driver;
        this.price = price;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
        setStatus(TripStatus.STARTED);
    }

    public String getId() {
        return id;
    }

//    private static synchronized String generateId() {
//        return "TRIP-" + (++idCounter);
//    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getPrice() {
        return price;
    }

    public Location getpickupLocation() {
        return pickupLocation;
    }

    public Location getdropoffLocation() {
        return dropoffLocation;
    }

    public DriverMatchingStrategy getDriverMatchingStrategy() {
        return driverMatchingStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        if(status == TripStatus.COMPLETED || status == TripStatus.CANCELLED) {
            driver.setAvailable(true);
        }
        if(status == TripStatus.STARTED) {
            driver.setAvailable(false);
        }
        this.status = status;
    }

    public void displayTrip() {
        System.out.println("---------------------------");
        System.out.println("Trip: "+id);
        System.out.println("Rider: "+rider.getName());
        System.out.println("Pickup Location: "+pickupLocation.getLatitude()+" "+pickupLocation.getLongitude());
        System.out.println("Drop Location: "+dropoffLocation.getLatitude()+" "+dropoffLocation.getLongitude());
        System.out.println("Driver: "+driver.getName());
        System.out.println("Price: "+price);
    }
}
