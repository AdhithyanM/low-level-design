package com.rideBooking;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    private static RiderManager instance;
    private Map<String, Rider> riders;

    private RiderManager() {
        riders = new HashMap<>();
    }

    public static RiderManager getInstance() {
        if (instance == null) {
            instance = new RiderManager();
        }
        return instance;
    }

    public void addRider(Rider rider) {
        riders.put(rider.getId(), rider);
    }

    public Rider getRider(String id) {
        return riders.get(id);
    }
}
