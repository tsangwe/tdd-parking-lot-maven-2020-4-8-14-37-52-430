package com.oocl.model;

public class ParkingTicket {
    private String ticketNumber;

    public ParkingTicket(int slotNumber) {
        this.ticketNumber = generateTicketNumber(slotNumber);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    private String generateTicketNumber(int slotNumber) {
        return slotNumber + "";
    }

    public int decodeTicketToSlotNumber() {
        return Integer.parseInt(this.getTicketNumber());
    }

}
