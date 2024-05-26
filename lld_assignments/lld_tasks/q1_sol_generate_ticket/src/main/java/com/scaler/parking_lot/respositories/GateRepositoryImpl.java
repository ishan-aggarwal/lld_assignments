package com.scaler.parking_lot.respositories;

import com.scaler.parking_lot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepositoryImpl implements GateRepository{
    // Do not modify the method signatures, feel free to add new methods

    private final Map<Long, Gate> gates = new HashMap<>();
    @Override
    public Optional<Gate> findById(long gateId) {
        return Optional.ofNullable(gates.get(gateId));
    }

    @Override
    public Gate save(Gate gate) {
        gates.put(gate.getId(), gate);
        return gate;
    }

}
