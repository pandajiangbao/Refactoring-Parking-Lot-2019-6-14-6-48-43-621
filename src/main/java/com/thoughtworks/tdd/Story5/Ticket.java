package com.thoughtworks.tdd.Story5;

public class Ticket {
    private Integer carId;
    private Integer parkingLotId;
    private boolean isValid;
    private String remark;

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
        this.isValid = valid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
