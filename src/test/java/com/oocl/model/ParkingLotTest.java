package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ParkingLotTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void should_return_true_when_car_parked_to_slot() throws ParkingLotIsFullException {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        if (parkingLot.park(car) != null) {
            Assert.assertEquals(true, parkingLot.getCarBySlotNumber(0) == car);
        }
    }

    @Test
    public void should_throw_parkingLotIsFullException_with_msg_notEnoughPosition_when_car_park_to_parkingLot_but_full() throws ParkingLotIsFullException {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Car[] slots = parkingLot.getSlots();

        for (int slotNumber = 0; slotNumber < slots.length; slotNumber++) {
            slots[slotNumber] = car;
        }

        exceptionRule.expect(ParkingLotIsFullException.class);
        exceptionRule.expectMessage("Not enough position.");
        parkingLot.park(car);
    }
}