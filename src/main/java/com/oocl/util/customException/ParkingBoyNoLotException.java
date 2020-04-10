package com.oocl.util.customException;

public class ParkingBoyNoLotException extends Exception {
    private static final String ERROR_MESSAGE = "Parking boy has no managing parking lot yet.";

    public ParkingBoyNoLotException() {
        super(ERROR_MESSAGE);
    }
}
