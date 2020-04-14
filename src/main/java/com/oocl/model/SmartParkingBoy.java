package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    protected ParkingLot selectParkingLot() throws ParkingLotIsFullException {
        return this.parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .max(Comparator.comparing(ParkingLot::getEmptySpaceCount))
                .orElseThrow(ParkingLotIsFullException::new);
    }
}
