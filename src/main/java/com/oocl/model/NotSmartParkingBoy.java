package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

import java.util.List;
import java.util.stream.Collectors;

public class NotSmartParkingBoy extends ParkingBoy {
    public NotSmartParkingBoy() {
        super();
    }

    @Override
    protected ParkingLot selectParkingLot() throws ParkingLotIsFullException {
        List<ParkingLot> nonFullParkingLots = this.parkingLots.stream().filter(parkingLot -> !parkingLot.isFull()).collect(Collectors.toList());
        if (!nonFullParkingLots.isEmpty()) {
            return nonFullParkingLots.get(0);
        }
        throw new ParkingLotIsFullException();
    }
}
