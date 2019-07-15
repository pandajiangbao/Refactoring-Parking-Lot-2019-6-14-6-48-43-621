package com.thoughtworks.tdd.Story6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test6 {

    @Test
    public void should_return_ticket_when_manager_store_car_in_his_own_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1,5);
        Manager serviceManager = new Manager(1,parkingLot,null);
        Car car = new Car(1);

        //when
        Ticket ticket = serviceManager.parking(car);
        //then

        Assertions.assertEquals(new Integer(1),ticket.getParkingLotId());
    }


    @Test
    public void should_return_car_when_manager_fetch_car_in_his_own_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1,5);
        Manager serviceManager = new Manager(1,parkingLot,null);//没手下
        Car car = new Car(1);
        //when
        Ticket ticket = serviceManager.parking(car);
        Car newCar = serviceManager.redeemCar(ticket);
        //then

        Assertions.assertEquals(car,newCar);
    }

    @Test
    public void should_return_ticket_when_manager_specify_a_parking_boy_to_store() {
        //given
        ParkingLot parkingLot = new ParkingLot(1,5);
        ParkingBoy parkingBoy =new ParkingBoy(1,parkingLot);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        Manager serviceManager = new Manager(1,(ParkingLot) null,parkingBoys);//管理着parkingBoy

        //when
        Ticket ticket = serviceManager.parking(1,new Car(1));//让id为1的boy去停车
        //then

        Assertions.assertEquals(new Integer(1),ticket.getOperatorId()); //停车人的id与预期相符
    }

    @Test
    public void should_return_car_when_manager_specify_a_parking_boy_to_fetch() {
        //given
        ParkingLot parkingLot = new ParkingLot(1,5);
        ParkingBoy parkingBoy =new ParkingBoy(1,parkingLot);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        Manager serviceManager = new Manager(1,parkingLot,parkingBoys);//管理着parkingBoy
        Car car = new Car(1);
        //when
        Ticket ticket = serviceManager.parking(car);
        Car newCar = (Car) serviceManager.redeemCar(1,ticket);//让id为1的boy去取车
        //then

        Assertions.assertEquals(car,newCar); //取到之前停的车
    }

    @Test
    public void should_return_error_msg_when_manager_specify_a_parking_boy_to_store_but_fail() {
        //given
        ParkingLot parkingLot = new ParkingLot(1,0);
        ParkingBoy parkingBoy =new ParkingBoy(1,parkingLot);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        Manager serviceManager = new Manager(1,(ParkingLot) null,parkingBoys);//管理着parkingBoy

        //when
        Ticket ticket = serviceManager.parking(1,new Car(1));//让id为1的boy去停车
        //then

        Assertions.assertEquals("Not enough position.",serviceManager.getErrorMsg());
    }

    @Test
    public void should_return_error_msg_when_manager_specify_a_parking_boy_to_fetch_but_fail() {
        //given
        ParkingLot parkingLot = new ParkingLot(1,5);
        ParkingBoy parkingBoy =new ParkingBoy(1,parkingLot);

        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy);
        Manager serviceManager = new Manager(1,parkingLot,parkingBoys);//管理着parkingBoy
        Car car = new Car(1);
        //when
        serviceManager.parking(car);
        Ticket ticket = new Ticket(2);
        ticket.setParkingLotId(1);
        Car newCar = (Car) serviceManager.redeemCar(1,ticket);//让1号boy去取2车，错误的票
        //then

        Assertions.assertEquals("Unrecognized parking ticket.",serviceManager.getErrorMsg()); //取到之前停的车
    }


}