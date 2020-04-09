package com.oocl.model;

import java.util.ArrayList;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private ArrayList<ParkingTicket> parkingTickets;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
        this.parkingTickets = new ArrayList<ParkingTicket>();
    }

    public ParkingTicket park(Car car) {
        Integer parkedAtSlot = parkingLot.park(car);
        if (parkedAtSlot == null) {
            System.out.println("Not enough position.");
            return null;
        }
        ParkingTicket ticket = new ParkingTicket(parkedAtSlot);
        parkingTickets.add(ticket);
        return ticket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (!isValidTicket(parkingTicket)) return null;
        return parkingLot.returnCar(parkingTicket.decodeTicketToSlotNumber());
    }

    private boolean isValidTicket(ParkingTicket parkingTicket) {
        return parkingTickets.contains(parkingTicket);
    }
}
