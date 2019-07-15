package com.thoughtworks.tdd.Story1;

public class Ticket {
    private Integer carId;
    private boolean isValidity;

    public Ticket(){
        this.isValidity = true;
    }
    public Ticket(Integer carId) {
        this.carId = carId;
        this.isValidity = true;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public boolean getValidity() {
        return isValidity;
    }

    public void setValidity(boolean validity) {
        validity = validity;
    }
}