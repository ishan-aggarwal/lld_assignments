package com.scaler.parking_lot.respositories;

import com.scaler.parking_lot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepositoryImpl implements VehicleRepository {
    // Do not modify the method signatures, feel free to add new methods

    private Map<String, Vehicle> hm = new HashMap<>();

    public Optional<Vehicle> getVehicleByRegistrationNumber(String registrationNumber) {
        return Optional.ofNullable(hm.get(registrationNumber));
    }

    public Vehicle save(Vehicle vehicle) {
        return hm.put(vehicle.getRegistrationNumber(), vehicle);
    }
}
