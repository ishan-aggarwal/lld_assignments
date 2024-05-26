package com.scaler.parking_lot.strategies.assignment;

import com.scaler.parking_lot.exceptions.ParkingSpotNotAvailableException;
import com.scaler.parking_lot.models.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SpotAssignmentStrategyImpl implements SpotAssignmentStrategy {

    public Optional<ParkingSpot> assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingSpotNotAvailableException {
        List<ParkingFloor> parkingFloor = parkingLot.getParkingFloors();
        for (ParkingFloor pf : parkingFloor) {
            if (pf.getStatus().equals(FloorStatus.OPERATIONAL)) {
                List<ParkingSpot> parkingSpots = pf.getSpots();
                for (ParkingSpot ps : parkingSpots) {
                    if (ps.getStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                        ps.setStatus(ParkingSpotStatus.OCCUPIED);
                        return Optional.of(ps);
                    }
                }
            }
        }
        return Optional.empty();
    }
}
