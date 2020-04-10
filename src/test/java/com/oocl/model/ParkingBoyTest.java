package com.oocl.model;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest {

    @Test
    public void should_return_parkingTicket_when_park_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        Assert.assertEquals(ParkingTicket.class, parkingTicket.getClass());
    }

    @Test
    public void should_return_parkingTicket_for_each_when_park_multiple_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Assert.assertEquals(ParkingTicket.class, parkingBoy.park(new Car()).getClass());
        Assert.assertEquals(ParkingTicket.class, parkingBoy.park(new Car()).getClass());
        Assert.assertEquals(ParkingTicket.class, parkingBoy.park(new Car()).getClass());
    }

    @Test
    public void should_return_null_when_park_car_to_parkingLot_that_full() {
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int index = 0; index < parkingBoy.getParkingLotCapacity(); index++) {
            parkingBoy.park(new Car());
        }
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        Assert.assertEquals(null, parkingTicket);
    }

    @Test
    public void should_return_car_when_packingBoy_fetch_with_valid_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carToPark = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(carToPark);
        Car returnedCar = parkingBoy.fetch(parkingTicket);
        Assert.assertEquals(carToPark, returnedCar);
    }

    @Test
    public void should_return_null_when_packingBoy_fetch_with_invalid_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car returnedCar = parkingBoy.fetch(new ParkingTicket(2));
        Assert.assertEquals(null, returnedCar);
    }

    @Test
    public void should_return_null_when_packingBoy_fetch_car_has_already_fetched_out() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carToPark = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(carToPark);
        Car returnedCar = parkingBoy.fetch(parkingTicket);
        Car returnedCar2 = parkingBoy.fetch(parkingTicket);
        Assert.assertEquals(null, returnedCar2);
    }
}