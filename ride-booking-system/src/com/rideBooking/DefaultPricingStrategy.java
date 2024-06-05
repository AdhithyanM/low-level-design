package com.rideBooking;

public class DefaultPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        return 10.0;
    }
}
