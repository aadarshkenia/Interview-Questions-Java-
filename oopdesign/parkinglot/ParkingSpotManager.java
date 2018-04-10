package oopdesign.parkinglot;

import java.util.Optional;

public interface ParkingSpotManager {
    void freeSpot(ParkingSpot parkingSpot);
    Optional<ParkingSpot> getFreeSpot(Vehicle v);
}
