package com.rideBooking;

public class StrategyManager {
    private static StrategyManager instance;
    private StrategyManager() {};

    public static StrategyManager getInstance() {
        if(instance == null) {
            instance = new StrategyManager();
        }
        return instance;
    }

    public DriverMatchingStrategy getDriverMatchingStrategy(TripMetaData tripMetaData) {
        // TO DO: customize as per the tripMetaData.
        return new LeastTimeTakenDMStrategy();
    }

    public PricingStrategy getPricingStrategy(TripMetaData tripMetaData) {
        // TO DO: customize as per the tripMetaData.
        return new DefaultPricingStrategy();
    }

}
