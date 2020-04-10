package com.oocl.model;

public class ParkingTicket {
    private String ticketNumber;
    private int parkingLotId;

    public ParkingTicket(int parkingLotId, int slotNumber) {
        this.ticketNumber = generateTicketNumber(slotNumber);
        this.parkingLotId = parkingLotId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    private String generateTicketNumber(int slotNumber) {
        return slotNumber + "";
    }

    public int decodeTicketToSlotNumber() {
        return Integer.parseInt(this.getTicketNumber());
    }

}
