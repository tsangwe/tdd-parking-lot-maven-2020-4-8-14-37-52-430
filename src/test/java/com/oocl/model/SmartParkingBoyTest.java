package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SmartParkingBoyTest {
    public static final int CAPACITY = 3;
    private ParkingBoy parkingBoy;
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;
    private ServiceManager serviceManager;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init() {
        parkingBoy = new SmartParkingBoy();
        firstParkingLot = new ParkingLot(1, CAPACITY);
        serviceManager = new ServiceManager();
    }

    @Test
    public void should_return_firstParkingLot_when_both_parkingLot_empty_space_are_same() throws ParkingLotIsFullException {
        secondParkingLot = new ParkingLot(2, CAPACITY);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, firstParkingLot);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        assertEquals(firstParkingLot, parkingBoy.selectParkingLot());
    }

    @Test
    public void should_return_secondParkingLot_when_more_empty_space_in_secondParkingLot() throws ParkingLotIsFullException {
        secondParkingLot = new ParkingLot(2, CAPACITY + 1);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, firstParkingLot);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        assertEquals(secondParkingLot, parkingBoy.selectParkingLot());
    }

    @Test
    public void should_throw_ParkingLotIsFullException_when_all_ParkingLot_is_full() throws ParkingLotIsFullException {
        secondParkingLot = new ParkingLot(2, CAPACITY);
        Car car = new Car();
        for (int count = 0; count < CAPACITY; count++) {
            firstParkingLot.park(car);
            secondParkingLot.park(car);
        }
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, firstParkingLot);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        exceptionRule.expect(ParkingLotIsFullException.class);
        exceptionRule.expectMessage("Not enough position.");
        parkingBoy.selectParkingLot();
    }

}