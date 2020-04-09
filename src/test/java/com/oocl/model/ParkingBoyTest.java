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

}