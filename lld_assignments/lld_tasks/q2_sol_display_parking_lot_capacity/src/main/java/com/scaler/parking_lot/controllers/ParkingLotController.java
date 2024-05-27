package com.scaler.parking_lot.controllers;

import com.scaler.parking_lot.dtos.GetParkingLotCapacityRequestDto;
import com.scaler.parking_lot.dtos.GetParkingLotCapacityResponseDto;
import com.scaler.parking_lot.dtos.Response;
import com.scaler.parking_lot.dtos.ResponseStatus;
import com.scaler.parking_lot.exceptions.GetParkingLotRequestValidationException;
import com.scaler.parking_lot.models.ParkingFloor;
import com.scaler.parking_lot.models.VehicleType;
import com.scaler.parking_lot.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public GetParkingLotCapacityResponseDto getParkingLotCapacity(GetParkingLotCapacityRequestDto getParkingLotCapacityRequestDto) {

        List<VehicleType> vehicleTypes = null;

        if (getParkingLotCapacityRequestDto.getVehicleTypes() != null) {
            vehicleTypes = new ArrayList<>();
            for (String vehicleType : getParkingLotCapacityRequestDto.getVehicleTypes()) {
                vehicleTypes.add(VehicleType.valueOf(vehicleType));//string to enum change
            }

        }

        GetParkingLotCapacityResponseDto response = new GetParkingLotCapacityResponseDto();
        try {
            Map<ParkingFloor, Map<String, Integer>> result = parkingLotService.getParkingLotCapacity(getParkingLotCapacityRequestDto.getParkingLotId(), getParkingLotCapacityRequestDto.getParkingFloorIds(), vehicleTypes);
            response.setResponse(new Response(ResponseStatus.SUCCESS, "successfully found"));
            response.setCapacityMap(result);
        } catch (Exception e) {
            response.setResponse(new Response(ResponseStatus.FAILURE, e.getMessage()));
        }

        return response;
    }
}
