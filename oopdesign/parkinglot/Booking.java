package oopdesign.parkinglot;

public class Booking {
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private long startTimeMillis;

    public Booking(ParkingSpot parkingSpot, Vehicle vehicle, long startTimeMillis) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTimeMillis = startTimeMillis;
    }
}
