package com.oocl.util.customException;

public class ParkingLotIsFullException extends Exception {
    public ParkingLotIsFullException(String errorMessage) {
        super(errorMessage);
    }
}
