package com.oocl.util.customException;

public class ParkingLotIsFullException extends Exception {
    private static final String ERROR_MESSAGE = "Not enough position.";

    public ParkingLotIsFullException() {
        super(ERROR_MESSAGE);
    }
}
