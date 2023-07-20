package com.zemoso.eventticketingsystem.controller.request;

import java.util.List;

public class PurchaseRequest {

    private int eventId;
    private int userId;
    private int ticketQuantity;

    private String ticketType;

    private List<Integer> seatNumbers;

    // Add any additional fields and methods as needed

    // Default constructor (required for JSON serialization/deserialization)
    public PurchaseRequest() {
    }

    public PurchaseRequest(int eventId, int userId, int ticketQuantity, String ticketType, List<Integer> seatNumbers) {
        this.eventId = eventId;
        this.userId = userId;
        this.ticketQuantity = ticketQuantity;
        this.ticketType = ticketType;
        this.seatNumbers = seatNumbers;
    }


    // Getters and setters for all fields
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public String getTicketType() {
        return ticketType;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }
}

