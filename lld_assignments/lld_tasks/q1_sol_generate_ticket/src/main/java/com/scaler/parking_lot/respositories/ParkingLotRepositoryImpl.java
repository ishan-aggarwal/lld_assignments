package com.scaler.parking_lot.respositories;

import com.scaler.parking_lot.models.Gate;
import com.scaler.parking_lot.models.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {
    // Do not modify the method signatures, feel free to add new methods
    private final Map<Long, ParkingLot> idToParkingLotMap = new HashMap<>();

    public Optional<ParkingLot> getParkingLotByGateId(long gateId) {
        for (Map.Entry<Long, ParkingLot> hm : idToParkingLotMap.entrySet()) {
            ParkingLot val = hm.getValue();
            List<Gate> listOfGate = val.getGates();
            for (Gate gate : listOfGate) {
                if (gate.getId() == gateId) {
                    return Optional.of(val);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<ParkingLot> getParkingLotById(long id) {
        return Optional.ofNullable(idToParkingLotMap.get(id));
    }

    public ParkingLot save(ParkingLot parkingLot) {
        return idToParkingLotMap.put(parkingLot.getId(), parkingLot);
    }
}