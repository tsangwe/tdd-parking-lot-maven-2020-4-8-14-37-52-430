package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

public class NotSmartParkingBoy extends ParkingBoy {
    @Override
    protected ParkingLot selectParkingLot() throws ParkingLotIsFullException {
        return this.parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(ParkingLotIsFullException::new);
    }
}
