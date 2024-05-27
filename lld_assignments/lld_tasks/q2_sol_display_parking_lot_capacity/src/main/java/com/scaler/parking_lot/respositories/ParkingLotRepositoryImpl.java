package com.scaler.parking_lot.respositories;

import com.scaler.parking_lot.models.Gate;
import com.scaler.parking_lot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    // Do not change the method signatures, feel free to add new methods

    Map<Long, ParkingLot> parkingLotDb1 = new HashMap<>();//getParkingLotById
    Map<Long, ParkingLot> parkingLotGateDb2 = new HashMap<>();//getParkingLotByGateId

    public Optional<ParkingLot> getParkingLotByGateId(long gateId) {
        if (parkingLotGateDb2.containsKey(gateId)) {
            return Optional.of(parkingLotGateDb2.get(gateId));
        }
        return Optional.empty();
    }

    public Optional<ParkingLot> getParkingLotById(long id) {
        if (parkingLotDb1.containsKey(id)) {
            return Optional.of(parkingLotDb1.get(id));
        }
        return Optional.empty();

    }

    public ParkingLot save(ParkingLot parkingLot) {

        parkingLotDb1.put(parkingLot.getId(), parkingLot);

        for (Gate g : parkingLot.getGates()) {
            parkingLotGateDb2.put(g.getId(), parkingLot);
        }
        return parkingLot;

    }

}
