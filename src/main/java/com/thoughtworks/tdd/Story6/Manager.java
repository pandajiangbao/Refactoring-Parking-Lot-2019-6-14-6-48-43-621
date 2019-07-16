package com.thoughtworks.tdd.Story6;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {

    private List<ParkingBoy> parkingBoys = new ArrayList<>();

    public Manager(Integer parkingBoyId, List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Manager(Integer parkingBoyId, ParkingLot parkingLot, List<ParkingBoy> parkingBoys) {
        super(parkingBoyId,parkingLot);
        this.parkingBoys = parkingBoys;
    }

    public Manager(Integer parkingBoyId , List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingBoyId,parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy){
        this.parkingBoys.add(parkingBoy);
    }

    public ParkingBoy getSpecifyParkingBoy(Integer parkingBoyId){
        ParkingBoy parkingBoy =null;
        for(ParkingBoy pb : this.parkingBoys){
            if(pb.getParkingBoyId().equals(parkingBoyId)){
                parkingBoy = pb;
                break;
            }
        }
        return parkingBoy;
    }

    //overload
    public Ticket parking(Integer parkingBoyId,Car car) {
        Ticket ticket =null;
        if(parkingBoyId!=null) {
            ParkingBoy parkingBoy = getSpecifyParkingBoy(parkingBoyId);
            if(parkingBoy!=null){
                ticket = parkingBoy.parking(car);
                if(ticket == null){
                    super.setErrorMsg(parkingBoy.getErrorMsg());
                }
            }

        }
        return ticket;
    }
    //overload
    public Car fetchCar(Integer parkingBoyId, Ticket ticket) {
        Car car = null;
        if(parkingBoyId!=null){
            ParkingBoy parkingBoy = getSpecifyParkingBoy(parkingBoyId);
            if(parkingBoy!=null){
                car = parkingBoy.fetchCar(ticket);
                if(car == null){
                    super.setErrorMsg(parkingBoy.getErrorMsg());
                }
            }
        }
        return car;
    }
}