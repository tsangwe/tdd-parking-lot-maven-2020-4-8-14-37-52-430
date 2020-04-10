package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

import java.util.ArrayList;

public class ParkingBoy {
    private static final int PARKING_LOT_CAPACITY = 10;
    private ParkingLot parkingLot;
    private ArrayList<ParkingTicket> parkingTickets;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot(PARKING_LOT_CAPACITY);
        this.parkingTickets = new ArrayList<ParkingTicket>();
    }

    public ParkingTicket park(Car car) {
        try {
            Integer parkedAtSlot = parkingLot.park(car);
            ParkingTicket ticket = new ParkingTicket(parkedAtSlot);
            parkingTickets.add(ticket);
            return ticket;
        } catch (ParkingLotIsFullException e) {
            return null;
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (!isValidTicket(parkingTicket)) return null;
        Car returningCar = parkingLot.returnCar(parkingTicket.decodeTicketToSlotNumber());
        if (returningCar != null) parkingTickets.remove(parkingTicket);
        return parkingLot.returnCar(parkingTicket.decodeTicketToSlotNumber());
    }

    private boolean isValidTicket(ParkingTicket parkingTicket) {
        return parkingTickets.contains(parkingTicket);
    }

    public static int getParkingLotCapacity() {
        return PARKING_LOT_CAPACITY;
    }
}
