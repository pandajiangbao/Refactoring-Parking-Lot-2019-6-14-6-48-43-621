package com.thoughtworks.tdd.Story6;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingBoy {

    private Integer parkingBoyId;
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private String errorMsg;

    public ParkingBoy() {

    }
    public ParkingBoy(Integer parkingBoyId,ParkingLot parkingLot) {
        this.parkingBoyId = parkingBoyId;
        this.parkingLots.add(parkingLot);
    }
    public ParkingBoy(Integer parkingBoyId,List<ParkingLot> parkingLots) {
        this.parkingBoyId = parkingBoyId;
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
            if(ticket !=null) {
                ticket.setOperatorId(this.parkingBoyId);
                break;
            }
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
        if(ticket.getParkingLotId()!=null) {
            for (int i = 0; i < parkingLots.size(); i++) {
                if (ticket.getParkingLotId().equals(parkingLots.get(i).getParkingLotId())) {
                    car = parkingLots.get(i).getCar(ticket.getCarId());
                    ticket.setOperatorId(this.parkingBoyId);
                    break;
                }
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


    public Integer getParkingBoyId() {
        return parkingBoyId;
    }

    public void setParkingBoyId(Integer parkingBoyId) {
        this.parkingBoyId = parkingBoyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingBoy)) return false;
        ParkingBoy that = (ParkingBoy) o;
        return Objects.equals(parkingBoyId, that.parkingBoyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingBoyId);
    }
}