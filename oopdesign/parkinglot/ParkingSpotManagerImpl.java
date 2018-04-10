package oopdesign.parkinglot;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

/***
 * Assumptions : Single level parking.
 * Map is from the size of parking spot to queue of spots available.
 */
public class ParkingSpotManagerImpl implements ParkingSpotManager {
    private Map<Integer, Queue<ParkingSpot>> spotMap = initializeSpots(); //TreeMap

    @Override
    public void freeSpot(ParkingSpot parkingSpot) {

    }

    @Override
    public Optional<ParkingSpot> getFreeSpot(Vehicle v) {
        //Get smallest queue of spots that fit this vehicle
        synchronized (spotMap) {
            for(int sizeKey : spotMap.keySet()) {
                if(sizeKey > v.getSize()) {
                    Queue<ParkingSpot> queue = spotMap.get(sizeKey);
                    if(queue.peek().isAvailable()) { //If spot is available, remove from front and add to end.
                        ParkingSpot spot = queue.poll();
                        spot.markUnavailable();
                        queue.add(spot);
                        return Optional.of(spot);
                    }
                }
            }
        }
        return Optional.empty();
    }

    private Map<Integer, Queue<ParkingSpot>> initializeSpots() {
        //TODO
        return Collections.emptyMap();
    }

}
