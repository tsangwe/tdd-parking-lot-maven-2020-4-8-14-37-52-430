package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    @Override
    public ParkingLot selectParkingLot() throws ParkingLotIsFullException {
        ParkingLot selectedParkingLots = this.parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparing(ParkingLot::getEmptySpace))
                .orElseGet(() -> parkingLots.get(0));
        if (selectedParkingLots != null) {
            return selectedParkingLots;
        }
        throw new ParkingLotIsFullException();
    }
}
