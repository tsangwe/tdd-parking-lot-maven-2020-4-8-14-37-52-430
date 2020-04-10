package com.oocl.util.customException;

public class InvalidTicketException extends Exception {
    private static final String ERROR_MESSAGE = "Unrecognized parking ticket.";

    public InvalidTicketException() {
        super(ERROR_MESSAGE);
    }
}
