package com.scaler.parking_lot.services;

import com.scaler.parking_lot.exceptions.InvalidParkingLotException;
import com.scaler.parking_lot.models.*;
import com.scaler.parking_lot.respositories.ParkingLotRepository;

import java.sql.SQLOutput;
import java.util.*;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public Map<ParkingFloor, Map<String, Integer>> getParkingLotCapacity(long parkingLotId, List<Long> parkingFloors, List<VehicleType> vehicleTypes) throws InvalidParkingLotException {

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotById(parkingLotId);

        if (optionalParkingLot.isEmpty()) {
            throw new InvalidParkingLotException("Invalid parkingLot ID");
        }

        Map<ParkingFloor, Map<String, Integer>> result = new HashMap<>();

        boolean floorsMentioned = (parkingFloors != null);
        boolean vehicleTypesMentioned = (vehicleTypes != null);

        Set<Long> parkingFloorsSet = new HashSet<>();
        Set<VehicleType> vehicleTypeSet = new HashSet<>();

        if (floorsMentioned) {
            parkingFloorsSet.addAll(parkingFloors);
        }

        if (vehicleTypesMentioned) {
            vehicleTypeSet.addAll(vehicleTypes);
        }

        ParkingLot parkingLot = optionalParkingLot.get();
        for (ParkingFloor floor : parkingLot.getParkingFloors()) {
            if (!floorsMentioned || parkingFloorsSet.contains(floor.getId())) {
                Map<String, Integer> vehicleTypesCapacity = new HashMap<>();
                for (ParkingSpot parkingSpot : floor.getSpots()) {
                    String vehicleTypeText = parkingSpot.getSupportedVehicleType().name();//enum to string change
                    if (!vehicleTypesMentioned || vehicleTypeSet.contains(parkingSpot.getSupportedVehicleType())) {
                        if (parkingSpot.getStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                            vehicleTypesCapacity.put(vehicleTypeText, vehicleTypesCapacity.getOrDefault(vehicleTypeText, 0) + 1);
                        }
                    }
                }

                if (vehicleTypesCapacity.size() > 0) {
                    result.put(floor, vehicleTypesCapacity);
                }
            }
        }

        return result;
    }
}