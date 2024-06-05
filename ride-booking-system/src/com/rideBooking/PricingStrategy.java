package com.rideBooking;

public interface PricingStrategy {
    double calculatePrice(TripMetaData tripMetaData);
}
