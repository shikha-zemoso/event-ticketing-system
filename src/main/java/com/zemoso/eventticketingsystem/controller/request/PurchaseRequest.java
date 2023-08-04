package com.zemoso.eventticketingsystem.controller.request;

import java.util.List;

public class PurchaseRequest {

    private int eventId;
    private int userId;
    private int ticketQuantity;

    private String ticketType;

    private List<Integer> seatNumbers;

    public PurchaseRequest(int eventId, int userId, int ticketQuantity, String ticketType, List<Integer> seatNumbers) {
        this.eventId = eventId;
        this.userId = userId;
        this.ticketQuantity = ticketQuantity;
        this.ticketType = ticketType;
        this.seatNumbers = seatNumbers;
    }

    public int getEventId() {
        return eventId;
    }

    public int getUserId() {
        return userId;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public String getTicketType() {
        return ticketType;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }
}

