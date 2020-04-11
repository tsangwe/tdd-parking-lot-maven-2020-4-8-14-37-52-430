package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SuperSmartParkingBoyTest {
    private static final int CAPACITY = 3;
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
        secondParkingLot = new ParkingLot(2, CAPACITY);
        serviceManager = new ServiceManager();
    }

    @Test
    public void select_firstParkingLot_when_firstParkingLot_has_higher_position_ratio_as_lower_capacity() throws ParkingLotIsFullException {
        secondParkingLot = new ParkingLot(2, CAPACITY - 1);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, firstParkingLot);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        Assert.assertEquals(firstParkingLot, parkingBoy.selectParkingLot());
    }

    @Test
    public void select_secondParkingLot_when_secondParkingLot_has_higher_position_ratio_as_lower_capacity() throws ParkingLotIsFullException {
        secondParkingLot = new ParkingLot(2, CAPACITY + 1);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, firstParkingLot);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        Assert.assertEquals(secondParkingLot, parkingBoy.selectParkingLot());
    }

    @Test
    public void select_secondParkingLot_when_firstParkingLot_has_lower_position_ratio_as_many_car_parked() throws ParkingLotIsFullException {
        secondParkingLot = new ParkingLot(2, CAPACITY);
        firstParkingLot.park(new Car());
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, firstParkingLot);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        Assert.assertEquals(secondParkingLot, parkingBoy.selectParkingLot());
    }
}