package com.thoughtworks.tdd.Story1;

public class Ticket {
    private Integer carId;
    private boolean isValid;

    public Ticket(){
        this.isValid = true;
    }
    public Ticket(Integer carId) {
        this.carId = carId;
        this.isValid = true;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public boolean getValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        valid = valid;
    }
}