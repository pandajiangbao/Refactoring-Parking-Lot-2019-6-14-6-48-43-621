package com.thoughtworks.tdd.Story5;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<>();
    private String errorMsg;

    public ParkingBoy() {

    }
    public ParkingBoy(ParkingLot parkingLot) { this.parkingLots.add(parkingLot);}
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }



    public Ticket parking(Car car){
        if(car.getCarId()==null) return null;
        Ticket ticket = null;
        for(int i=0;i<parkingLots.size();i++){
            ticket = parkingLots.get(i).park(car);
            if(ticket !=null) break;;
        }
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
        if(!ticket.getValidity()){
            this.errorMsg="Unrecognized parking ticket.";
            return null;
        }
        Car car = null;
        for(int i=0;i<parkingLots.size();i++){
            if(ticket.getParkingLotId().equals(parkingLots.get(i).getParkingLotId())){
                car = parkingLots.get(i).getCar(ticket.getCarId());
                break;
            }
        }
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