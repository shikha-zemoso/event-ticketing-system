package com.zemoso.eventticketingsystem.exception;

public class NotEnoughSeatsException extends RuntimeException {

    public NotEnoughSeatsException(String message) {
        super(message);
    }

    public NotEnoughSeatsException(String message, Throwable cause) {
        super(message, cause);
    }
}