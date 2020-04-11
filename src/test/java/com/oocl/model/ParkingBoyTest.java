package com.oocl.model;

import com.oocl.util.customException.InvalidTicketException;
import com.oocl.util.customException.MissingTicketException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingBoyTest {
    public static final int CAPACITY = 10;
    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot;
    private ServiceManager serviceManager = new ServiceManager();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init() {
        parkingBoy = new NotSmartParkingBoy();
        parkingLot = new ParkingLot(1, CAPACITY);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, parkingLot);
    }

    @Test
    public void should_return_parkingTicket_when_park_car() {
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        Assert.assertEquals(ParkingTicket.class, parkingTicket.getClass());
    }

    @Test
    public void should_return_parkingTicket_for_each_when_park_multiple_car() {
        Assert.assertEquals(ParkingTicket.class, parkingBoy.park(new Car()).getClass());
        Assert.assertEquals(ParkingTicket.class, parkingBoy.park(new Car()).getClass());
        Assert.assertEquals(ParkingTicket.class, parkingBoy.park(new Car()).getClass());
    }

    @Test
    public void should_return_null_when_park_car_to_parkingLot_that_full() {
        for (int index = 0; index < parkingLot.getCapacity(); index++) {
            parkingBoy.park(new Car());
        }
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        Assert.assertEquals(null, parkingTicket);
    }

    @Test
    public void should_return_car_when_parkingBoy_fetch_with_valid_ticket() {
        Car carToPark = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(carToPark);
        Car returnedCar = parkingBoy.fetch(parkingTicket);
        Assert.assertEquals(carToPark, returnedCar);
    }

    @Test
    public void should_return_null_when_parkingBoy_fetch_with_invalid_ticket() {
        Car returnedCar = parkingBoy.fetch(new ParkingTicket(1, 2));
        Assert.assertEquals(null, returnedCar);
    }

    @Test
    public void should_return_null_when_parkingBoy_fetch_car_has_already_fetched_out() {
        Car carToPark = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(carToPark);
        Car returnedCar = parkingBoy.fetch(parkingTicket);
        Car returnedCar2 = parkingBoy.fetch(parkingTicket);
        Assert.assertEquals(null, returnedCar2);
    }

    @Test
    public void should_throw_missingTicketException_when_parkingBoy_fetch_car_without_ticket() throws MissingTicketException {
        exceptionRule.expect(MissingTicketException.class);
        exceptionRule.expectMessage("Please provide your parking ticket.");
        parkingBoy.ticketProvided(null);
    }

    @Test
    public void should_throw_exception_when_parkingBoy_fetch_car_with_invalid_ticket() throws InvalidTicketException {
        ParkingTicket parkingTicket = new ParkingTicket(1, 99);
        exceptionRule.expect(InvalidTicketException.class);
        exceptionRule.expectMessage("Unrecognized parking ticket.");
        parkingBoy.isValidTicket(parkingTicket);
    }

    @Test
    public void should_park_car_sequentially_when_not_smart_parkingBoy_park_car() {
        ParkingLot secondParkingLot = new ParkingLot(2, CAPACITY);
        serviceManager.assignParkingLotToParkingBoy(parkingBoy, secondParkingLot);
        parkingBoy.park(new Car());
        Assert.assertNotNull(parkingLot.getCarBySlotNumber(0));
        Assert.assertNull(secondParkingLot.getCarBySlotNumber(0));

        for (int count = 0; count < CAPACITY; count++) {
            parkingBoy.park(new Car());
        }

        Assert.assertTrue(parkingLot.isFull());
        Assert.assertNotNull(secondParkingLot.getCarBySlotNumber(0));
    }
}