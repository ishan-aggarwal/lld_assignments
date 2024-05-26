package com.scaler.parking_lot.services;

import com.scaler.parking_lot.exceptions.InvalidGateException;
import com.scaler.parking_lot.exceptions.InvalidParkingLotException;
import com.scaler.parking_lot.exceptions.ParkingSpotNotAvailableException;
import com.scaler.parking_lot.models.*;
import com.scaler.parking_lot.respositories.GateRepository;
import com.scaler.parking_lot.respositories.ParkingLotRepository;
import com.scaler.parking_lot.respositories.TicketRepository;
import com.scaler.parking_lot.respositories.VehicleRepository;
import com.scaler.parking_lot.strategies.assignment.SpotAssignmentStrategy;

import java.util.Date;

import static com.scaler.parking_lot.models.GateType.EXIT;

public class TicketServiceImpl implements TicketService {

    GateRepository gateRepository;

    ParkingLotRepository parkingLotRepository;

    TicketRepository ticketRepository;

    VehicleRepository vehicleRepository;

    SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketServiceImpl(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository, SpotAssignmentStrategy spotAssignmentStrategy) {

        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    @Override
    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleType) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException {

        Gate gate = gateRepository.findById(gateId).orElseThrow(() -> new InvalidGateException("Gate is null"));
        if (gate.getType() == EXIT) {
            throw new InvalidGateException("Not allow from exit game, come from entry gate");
        }

        Vehicle v = new Vehicle();
        v.setRegistrationNumber(registrationNumber);
        v.setVehicleType(VehicleType.valueOf(vehicleType));

        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(gateId).orElseThrow(() -> new InvalidParkingLotException("Invalid lot"));
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, v.getVehicleType()).orElseThrow(() -> new ParkingSpotNotAvailableException("NOT avbilable"));

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setVehicle(v);
        ticket.setParkingSpot(parkingSpot);

        ParkingAttendant pA = new ParkingAttendant();
        pA.setName("Ak");
        pA.setEmail("ak123@gmail.com");

        ticket.setParkingAttendant(pA);
        vehicleRepository.save(v);
        ticketRepository.save(ticket);
        return ticket;
    }
}
