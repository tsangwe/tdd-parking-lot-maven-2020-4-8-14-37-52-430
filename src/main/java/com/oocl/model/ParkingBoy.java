package com.oocl.model;

import com.oocl.util.customException.InvalidTicketException;
import com.oocl.util.customException.MissingTicketException;
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
        try {
            if (ticketProvided(parkingTicket) && isValidTicket(parkingTicket)) {
                Car returningCar = parkingLot.returnCar(parkingTicket.decodeTicketToSlotNumber());
                if (returningCar != null) parkingTickets.remove(parkingTicket);
                return returningCar;
            }
            return null;
        } catch (MissingTicketException e) {
            return null;
        } catch (InvalidTicketException e) {
            return null;
        }
    }

    public boolean ticketProvided(ParkingTicket parkingTicket) throws MissingTicketException {
        if (parkingTicket == null) throw new MissingTicketException();
        return true;
    }

    public boolean isValidTicket(ParkingTicket parkingTicket) throws InvalidTicketException {
        if (!this.parkingTickets.contains(parkingTicket)) throw new InvalidTicketException();
        return true;
    }

    public static int getParkingLotCapacity() {
        return PARKING_LOT_CAPACITY;
    }

}
