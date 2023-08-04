package com.zemoso.eventticketingsystem.exception;

public class NotEnoughSeatsException extends RuntimeException {

    public NotEnoughSeatsException(String message) {
        super(message);
    }
}