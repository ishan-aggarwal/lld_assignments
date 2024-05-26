package com.scaler.parking_lot.models;

import java.util.List;

public class ParkingFloor extends BaseModel{

    private List<ParkingSpot> spots;
    private int floorNumber;
    private FloorStatus status;

    public ParkingFloor(List<ParkingSpot> spots , int floorNumber , FloorStatus status){
      this.spots = spots;
      this.floorNumber = floorNumber;
      this.status = status;
    }

    public ParkingFloor(){
      
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public FloorStatus getStatus() {
        return status;
    }

    public void setStatus(FloorStatus status) {
        this.status = status;
    }
}