package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmartParkingBoyTest {
    public static final int CAPACITY = 3;
    private ParkingBoy parkingBoy;
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;
    private ServiceManager serviceManager;

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

//    @Test
//    public void should_return_parkingLot_when_more_empty_space_in_parkingLot() {
//        parkingLot = new ParkingLot(1, CAPACITY);
//        secondParkingLot = new ParkingLot(2, CAPACITY);
//        serviceManager.assignParkingLotToParkingBoy(parkingBoy, parkingLot);
//        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
//    }

}