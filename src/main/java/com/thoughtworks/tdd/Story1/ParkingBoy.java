package com.thoughtworks.tdd.Story1;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy() {

    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parking(Car car){
        if(car.getCarId()==null) return null;
        return parkingLot.park(car);
    }
    public Car redeemCar(Ticket ticket){
        if(ticket==null||(!ticket.getValidity())) return null;
        return parkingLot.getCar(ticket.getCarId());
    }


}