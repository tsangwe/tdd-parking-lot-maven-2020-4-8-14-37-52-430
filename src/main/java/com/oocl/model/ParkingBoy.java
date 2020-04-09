package com.oocl.model;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public ParkingTicket park(Car car) {
        Integer parkedAtSlot = parkingLot.park(car);
        if (parkedAtSlot == null) {
            System.out.println("Not enough position.");
            return null;
        }
        return new ParkingTicket(parkedAtSlot);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.returnCar(parkingTicket.decodeTicketToSlotNumber());
    }
}
