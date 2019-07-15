package com.thoughtworks.tdd.Story5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5 {

    @Test
    public void should_return_ticket_when_park_a_car() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car);
        //then
        Assertions.assertNotNull(ticket);
    }


    @Test
    public void should_return_car_when_submit_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(new Car(1));
        Car car = parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertNotNull(car);
    }


    @Test
    public void should_return_carCount_when_park_cars() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.parking(car1);
        parkingBoy.parking(car2);
        List<Car> carList = parkingLot.getCarList();
        //then
        Assertions.assertEquals(2,carList.size());
    }


    @Test
    public void should_return_correct_car_when_submit_a_ticket() {
        //given
        Car audi = new Car(100);
        Car maserati = new Car(200);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket audiTicket=parkingBoy.parking(audi);
        Ticket maseratiTicket = parkingBoy.parking(maserati);
        Car car = parkingBoy.redeemCar(maseratiTicket);

        //then
        Assertions.assertEquals(maserati,car);
    }


    @Test
    public void should_return_null_when_do_not_submit_ticket() {
        //given
        Car maserati = new Car(200);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket maseratiTicket = parkingBoy.parking(maserati);
        Car car = parkingBoy.redeemCar(null);

        //then
        Assertions.assertNull(car);
    }


    @Test
    public void should_return_null_when_submit_error_ticket() {
        //given
        Car maserati = new Car(200);
        Ticket ticket = new Ticket(23);
        ticket.setParkingLotId(1);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket maseratiTicket = parkingBoy.parking(maserati);
        Car car = parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertNull(car);
    }


    @Test
    public void should_return_null_when_ticket_is_invalidity() {
        //given
        Car maserati = new Car(200);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket maseratiTicket = parkingBoy.parking(maserati);
        Car car = parkingBoy.redeemCar(maseratiTicket);
        Car car2 = parkingBoy.redeemCar(maseratiTicket);

        //then
        Assertions.assertNull(car2);
    }


    @Test
    public void should_return_null_when_parking_lot_is_full_of_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=1;i<=10;i++){
            parkingBoy.parking(new Car(i));
        }
        Car car11 = new Car(11);

        //when
        Ticket ticket = parkingBoy.parking(car11);
        //then
        Assertions.assertNull(ticket);
    }


    @Test
    public void should_get_error_msg_when_ticket_is_invalidity() {
        //given
//        Car maserati = new Car(200);
        Ticket ticket = new Ticket(1);
        ticket.setValid(false);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
//        Ticket maseratiTicket = parkingBoy.parking(maserati);
        parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingBoy.getErrorMsg());
    }


    @Test
    public void should_get_error_msg_when_ticket_is_not_provide() {
        //given
        Car maserati = new Car(200);
        Ticket ticket = new Ticket(1);
        ticket.setParkingLotId(1);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket maseratiTicket = parkingBoy.parking(maserati);
        parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingBoy.getErrorMsg());
    }


    @Test
    public void should_get_error_msg_when_do_not_submit_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.redeemCar(null);

        //then
        Assertions.assertEquals("Please provide your parking ticket.",parkingBoy.getErrorMsg());
    }


    @Test
    public void should_get_error_msg_when_parking_lot_is_full_of_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=1;i<=10;i++){
            parkingBoy.parking(new Car(i));
        }
        Car car11 = new Car(11);

        //when
        parkingBoy.parking(car11);
        //then
        Assertions.assertEquals("Not enough position.",parkingBoy.getErrorMsg());
    }

    @Test
    public void should_park_the_next_parking_lot_when_parking_lot_one_is_full_of_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(new ParkingLot(1),new ParkingLot(2)));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for(int i=1;i<=10;i++){
            parkingBoy.parking(new Car(i));
        }
        Car car11 = new Car(11);

        //when
        Ticket ticket = parkingBoy.parking(car11);
        //then
        Assertions.assertEquals(new Integer(2),ticket.getParkingLotId());
    }

    @Test
    public void should_choose_the_best_parking_lot_when_park_the_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(new ParkingLot(1,2),new ParkingLot(2,5),new ParkingLot(3,10)));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        Ticket ticket = smartParkingBoy.parking(new Car(1));
        //then
        Assertions.assertEquals(new Integer(3),ticket.getParkingLotId());
    }

    @Test
    public void should_choose_usage_min_parking_lot_when_park_the_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1,5);
        ParkingLot parkingLot2 = new ParkingLot(2,3);
        List<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot1,parkingLot2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1);

        //when
        Ticket ticket1 = parkingBoy.parking(new Car(1));

        Ticket ticket2 = superSmartParkingBoy.parking(new Car(2));
        //then
        Assertions.assertEquals(new Integer(1),ticket1.getParkingLotId());
        Assertions.assertEquals(new Integer(2),ticket2.getParkingLotId());
    }
}