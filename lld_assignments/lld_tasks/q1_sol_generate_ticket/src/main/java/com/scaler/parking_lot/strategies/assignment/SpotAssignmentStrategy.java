package com.scaler.parking_lot.strategies.assignment;

import com.scaler.parking_lot.models.ParkingLot;
import com.scaler.parking_lot.models.ParkingSpot;
import com.scaler.parking_lot.models.VehicleType;
import com.scaler.parking_lot.exceptions.ParkingSpotNotAvailableException;

import java.util.Optional;

public interface SpotAssignmentStrategy {

    Optional<ParkingSpot> assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingSpotNotAvailableException;

}
