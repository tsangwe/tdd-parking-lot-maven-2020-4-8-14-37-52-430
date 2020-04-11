package com.oocl.model;

import com.oocl.util.customException.InvalidTicketException;
import com.oocl.util.customException.MissingTicketException;
import com.oocl.util.customException.ParkingBoyNoLotException;
import com.oocl.util.customException.ParkingLotIsFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ParkingBoy {
    protected ArrayList<ParkingLot> parkingLots;
    private ArrayList<ParkingTicket> parkingTickets;

    public ParkingBoy() {
        this.parkingLots = new ArrayList<ParkingLot>();
        this.parkingTickets = new ArrayList<ParkingTicket>();
    }

    protected void manageParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    protected abstract ParkingLot selectParkingLot() throws ParkingLotIsFullException;

    public ParkingLot getManagingParkingLotById(int id) {
        List<ParkingLot> parkingLotsMatchedWithId = parkingLots.stream().filter(parkingLot -> parkingLot.getId() == id).collect(Collectors.toList());
        if (!parkingLotsMatchedWithId.isEmpty()) {
            return parkingLotsMatchedWithId.get(0);
        }
        return null;
    }

    public ParkingTicket park(Car car) {
        try {
            if (this.parkingLots.isEmpty()) throw new ParkingBoyNoLotException();
            ParkingLot selectedParkingLot = selectParkingLot();
            Integer parkedAtSlot = selectedParkingLot.park(car);
            ParkingTicket ticket = new ParkingTicket(selectedParkingLot.getId(), parkedAtSlot);
            parkingTickets.add(ticket);
            return ticket;
        } catch (ParkingLotIsFullException e) {
            return null;
        } catch (ParkingBoyNoLotException e) {
            return null;
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        try {
            if (ticketProvided(parkingTicket) && isValidTicket(parkingTicket)) {
                ParkingLot parkingLot = getManagingParkingLotById(parkingTicket.getParkingLotId());
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

    protected boolean ticketProvided(ParkingTicket parkingTicket) throws MissingTicketException {
        if (parkingTicket == null) throw new MissingTicketException();
        return true;
    }

    protected boolean isValidTicket(ParkingTicket parkingTicket) throws InvalidTicketException {
        if (!this.parkingTickets.contains(parkingTicket)) throw new InvalidTicketException();
        return true;
    }

}
