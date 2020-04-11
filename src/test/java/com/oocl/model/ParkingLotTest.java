package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ParkingLotTest {
    private static final int PARKING_LOT_CAPACITY = 10;
    private ParkingLot parkingLot;
    private Car car;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init() {
        parkingLot = new ParkingLot(1, PARKING_LOT_CAPACITY);
        car = new Car();
    }

    @Test
    public void should_return_true_when_car_parked_to_slot() throws ParkingLotIsFullException {
        if (parkingLot.park(car) != null) {
            Assert.assertEquals(true, parkingLot.getCarBySlotNumber(0) == car);
        }
    }

    @Test
    public void should_throw_parkingLotIsFullException_with_msg_notEnoughPosition_when_car_park_to_parkingLot_but_full() throws ParkingLotIsFullException {
        Car[] slots = parkingLot.getSlots();

        for (int slotNumber = 0; slotNumber < slots.length; slotNumber++) {
            slots[slotNumber] = car;
        }

        exceptionRule.expect(ParkingLotIsFullException.class);
        exceptionRule.expectMessage("Not enough position.");
        parkingLot.park(car);
    }
}