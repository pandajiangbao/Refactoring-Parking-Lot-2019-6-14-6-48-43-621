package com.thoughtworks.tdd.Story1;

public class Ticket {
    private Integer carId;
    private boolean validity;//true 为 有效，false 为无效（已使用）

    public Ticket(){
        this.validity = true;
    }
    public Ticket(Integer carId) {
        this.carId = carId;
        this.validity = true;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public boolean getValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        validity = validity;
    }
}