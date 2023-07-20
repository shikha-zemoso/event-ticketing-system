package com.zemoso.eventticketingsystem.exception;

public class WaitingListNotFoundException extends RuntimeException {

    public WaitingListNotFoundException(String message) {
        super(message);
    }

    public WaitingListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

