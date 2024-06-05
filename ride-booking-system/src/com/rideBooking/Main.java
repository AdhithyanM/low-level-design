package com.rideBooking;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rider adhiRider = new Rider("adhithyan");
        Rider vickyRider = new Rider("vignesh");
        RiderManager riderManager = RiderManager.getInstance();
        riderManager.addRider(adhiRider);
        riderManager.addRider(vickyRider);

        Driver driver1 = new Driver("vishal", 5);
        Driver driver2 = new Driver("Bala", 4);
        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(driver1);
        driverManager.addDriver(driver2);

        TripManager tripManager = TripManager.getInstance();
        Trip trip1 = tripManager.createTrip(adhiRider, new Location(1, 2), new Location(6,8));
        if(trip1 == null) {
            System.out.println("Trip is not created");
        }

        Trip trip2 = tripManager.createTrip(vickyRider, new Location(4,4), new Location(7,7));
        if(trip2 == null) {
            System.out.println("Trip is not created");
        }

        List<Trip> createdTrips = tripManager.getAllTrips();
        for(Trip trip: createdTrips) {
            trip.displayTrip();
        }
    }
}
