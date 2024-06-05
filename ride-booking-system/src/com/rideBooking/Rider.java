package com.rideBooking;

import java.util.UUID;

public class Rider {
//    private static int idCounter = 0;
    private String id;
    private String name;
    private double rating;

    public Rider(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

//    private synchronized static String generateId() {
//        return "RIDER-" + (++idCounter);
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
}
