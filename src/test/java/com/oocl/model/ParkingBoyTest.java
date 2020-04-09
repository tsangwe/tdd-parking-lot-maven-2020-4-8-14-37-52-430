package com.oocl.model;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {

    @Test
    public void should_return_packingTicket_when_park_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        Assert.assertEquals(ParkingTicket.class, parkingTicket.getClass());
    }

    @Test
    public void should_return_car_when_packingBoy_fetch_with_valid_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carToPark = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(carToPark);
        Car returnedCar = parkingBoy.fetch(parkingTicket);
        Assert.assertEquals(carToPark, returnedCar);
    }

}