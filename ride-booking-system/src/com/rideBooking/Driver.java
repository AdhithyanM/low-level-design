package com.rideBooking;

import java.util.UUID;

public class Driver {
//    private static int idCounter = 0;
    private String id;
    private String name;
    private boolean isAvailable;
    private double rating;

    public Driver(String name, double rating) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

//    private synchronized static String generateId() {
//        return "DRIVER-" + (++idCounter);
//    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
