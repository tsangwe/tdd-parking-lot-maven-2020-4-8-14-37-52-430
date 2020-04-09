package com.oocl.model;

import org.junit.Assert;
import org.junit.Test;


public class ParkingLotTest {

    @Test
    public void should_return_true_when_car_parked_to_slot() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        if (parkingLot.park(car) != null) {
            Assert.assertEquals(true, parkingLot.getCarBySlotNumber(0) == car);
        }
    }

    @Test
    public void should_return_false_when_car_park_to_slot_but_full() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Car[] slots = parkingLot.getSlots();

        for (int slotNumber = 0; slotNumber < slots.length; slotNumber++) {
            slots[slotNumber] = car;
        }

        Assert.assertEquals(null, parkingLot.park(car));
    }
}