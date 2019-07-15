package com.thoughtworks.tdd.Story2;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private String errorMsg;

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
        Ticket ticket = parkingLot.park(car);
        if(ticket == null){
            this.errorMsg = "Not enough position.";
        }
        return ticket;
    }
    public Car redeemCar(Ticket ticket){

        System.out.println(ticket);
        if(ticket == null) {
            this.errorMsg="Please provide your parking ticket.";
            return null;
        }
        if(!ticket.getValid()){
            this.errorMsg="Unrecognized parking ticket.";
            return null;
        }
        Car car = parkingLot.getCar(ticket.getCarId());
        if(car == null){
            this.errorMsg="Unrecognized parking ticket.";
        }
        return car;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}