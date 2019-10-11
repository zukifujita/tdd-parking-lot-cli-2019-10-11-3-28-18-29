package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_park_a_car_into_parking_lot_by_parking_boy_and_returns_a_ticket() {
        //given
        Car cars = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        ParkingTicket ticket = parkingBoy.park(cars);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_a_car_by_parking_boy() {
        //given
        Car car = new Car();
        Car otherCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        parkingLot.park(car);
        parkingLot.park(otherCar);
        ParkingTicket ticket = parkingBoy.park(car);
        //then
        assertEquals(2, ticket);
    }

    @Test
    void should_fetch_right_car_using_ticket() {
        //given
        Car car = new Car();
        Car otherCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket ticket = parkingBoy.park(car);
        ParkingTicket ticket2 = parkingBoy.park(otherCar);
        //when
        parkingLot.fetch(ticket);
        parkingLot.fetch(ticket2);
        //then
        assertNotEquals(car, otherCar);
    }

    @Test
    void customer_gives_wrong_ticket_then_no_car_fetched() {

    }
}