package com.oocl.util.customException;

public class MissingTicketException extends Exception {
    private static final String ERROR_MESSAGE = "Please provide your parking ticket.";

    public MissingTicketException() {
        super(ERROR_MESSAGE);
    }
}
