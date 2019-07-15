package com.thoughtworks.tdd.Story6;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(Integer parkingBoyId ,ParkingLot parkingLot) {
        super(parkingBoyId,parkingLot);
    }

    public SuperSmartParkingBoy(Integer parkingBoyId ,List<ParkingLot> parkingLots) {
        super(parkingBoyId,parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        if(car.getCarId()==null) return null;
        Ticket ticket = null;
        List<ParkingLot> parkingLots = super.getParkingLots();
        int index = -1;
        double usageMin = 1d;
        for(int i=0;i<parkingLots.size();i++){
            double usage = (double)parkingLots.get(i).getCarList().size()/parkingLots.get(i).getMax();
            if(usageMin>usage){
                index = i;
                usageMin = usage;
            }
        }
        if(usageMin == 1d){
            super.setErrorMsg("Not enough position.");
        }else{
            ticket = parkingLots.get(index).park(car);
            ticket.setOperatorId(super.getParkingBoyId());
        }
        return ticket;
    }
}