package com.thoughtworks.tdd.Story1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test1 {

    @Test
    public void should_return_ticket_when_park_a_car() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_give_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(new Car(1));
        Car car = parkingBoy.returnCar(ticket);

        //then
        Assertions.assertNotNull(car);
    }

    @Test
    public void should_return_carCount_when_park_cars() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.parking(car1);
        parkingBoy.parking(car2);
        List<Car> carList = parkingLot.getCarList();
        //then
        Assertions.assertEquals(2,carList.size());
    }

    @Test
    public void should_return_correct_car_when_give_a_ticket() {
        //given
        Car car1 = new Car(200);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car1);
        Car car = parkingBoy.returnCar(ticket);

        //then
        Assertions.assertEquals(car1,car);
    }

    @Test
    public void should_return_null_when_do_not_submit_ticket() {
        //given
        Car car1 = new Car(200);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car1);
        Car car = parkingBoy.returnCar(null);

        //then
        Assertions.assertNull(car);
    }

    @Test
    public void should_return_null_when_submit_error_ticket() {
        //given
        Car car1 = new Car(200);
        Ticket ticket = new Ticket(23);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket1 = parkingBoy.parking(car1);
        Car car = parkingBoy.returnCar(ticket);

        //then
        Assertions.assertNull(car);
    }

    @Test
    public void should_return_null_when_ticket_is_invalidity() {
        //given
        Car car1 = new Car(200);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car1);
        Car car = parkingBoy.returnCar(ticket);
        Car car2 = parkingBoy.returnCar(ticket);

        //then
        Assertions.assertNull(car2);
    }

    @Test
    public void should_return_null_when_parking_lot_is_full_of_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
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

}
