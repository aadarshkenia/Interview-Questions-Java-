package oopdesign.parkinglot;

public class ParkingSpot {
    private int size;
    private boolean available = true;

    public ParkingSpot(int size) {
        this.size = size;
    }

    public void markAvailable() {available = true;}
    public void markUnavailable() {available = false;}
    public boolean isAvailable() {return available;}
}
