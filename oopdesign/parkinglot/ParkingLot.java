package oopdesign.parkinglot;

import java.util.Optional;

public class ParkingLot {
    private ParkingSpotManager spotManager;
    private PricingEngine pricingEngine;

    public ParkingLot() {
        //To initialize the parking lot.
    }


    public Booking createBooking(Vehicle v) {
        Optional<ParkingSpot> parkingSpot = spotManager.getFreeSpot(v);
        if(!parkingSpot.isPresent()) {
            throw new RuntimeException("No Parking Spot Available.");
        }
        Booking booking = new Booking(parkingSpot.get(), v, System.currentTimeMillis());
        return booking;
    }
}
