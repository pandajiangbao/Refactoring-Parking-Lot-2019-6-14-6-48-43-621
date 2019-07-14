package com.thoughtworks.tdd.Story3;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {


    private Integer parkingLotId;
    private List<Car> carList;
    private int max=10;
    public ParkingLot() {
        carList = new ArrayList<>();
    }

    public ParkingLot(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
        carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public ParkingLot(Integer parkingLotId, int max) {
        this.parkingLotId = parkingLotId;
        this.max = max;
        this.carList = new ArrayList<>();
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }


    public Ticket park(Car car){
        if(this.carList.size()>=this.max){
            return null;
        }
        this.carList.add(car);
        Ticket ticket = new Ticket(car.getCarId());
        ticket.setParkingLotId(this.parkingLotId);
        return ticket;
    }

    public Car getCar(Integer carId) {
        if(carId==null) return  null;
        for(int i=0;i<carList.size();i++){
            if(carList.get(i).getCarId().equals(carId)){
                Car car = carList.get(i);
                carList.remove(i);
                return car;
            }
        }
        return null;
    }
    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

}
