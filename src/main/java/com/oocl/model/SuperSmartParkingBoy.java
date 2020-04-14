package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    protected ParkingLot selectParkingLot() throws ParkingLotIsFullException {
        ParkingLot selectedParkingLots = this.parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparing(ParkingLot::computerAvailablePositionRate))
                .orElseGet(() -> parkingLots.get(0));
        if (!selectedParkingLots.isFull()) {
            return selectedParkingLots;
        }
        throw new ParkingLotIsFullException();
    }
}
