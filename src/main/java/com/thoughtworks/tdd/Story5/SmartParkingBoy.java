package com.thoughtworks.tdd.Story5;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        if(car.getCarId()==null) return null;
        Ticket ticket = null;
        List<ParkingLot> parkingLots = super.getParkingLots();
        int index = -1;
        int remainCount=0;
        for(int i=0;i<parkingLots.size();i++){
            int count = parkingLots.get(i).getMax()-parkingLots.get(i).getCarList().size();
            if(count>remainCount){
                index = i;
                remainCount = count;
            }
        }
        if(remainCount==0){
            super.setErrorMsg("Not enough position.");
        }else{
            ticket = parkingLots.get(index).park(car);
        }
        return ticket;
    }
}
