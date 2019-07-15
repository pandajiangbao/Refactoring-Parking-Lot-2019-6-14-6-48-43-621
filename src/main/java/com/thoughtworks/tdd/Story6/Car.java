package com.thoughtworks.tdd.Story6;

public class Car {
    private Integer carId;

    public Car(){

    }
    public Car(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
