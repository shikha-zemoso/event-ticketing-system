package com.zemoso.eventticketingsystem.controller.request;

import java.util.List;

public class SeatSelectionRequest {

    private int eventId;
    private int userId;
    private List<Integer> selectedSeats;

    // Add any additional fields and methods as needed

    // Default constructor (required for JSON serialization/deserialization)
    public SeatSelectionRequest() {
    }

    public SeatSelectionRequest(int eventId, int userId, List<Integer> selectedSeats) {
        this.eventId = eventId;
        this.userId = userId;
        this.selectedSeats = selectedSeats;
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

    public List<Integer> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<Integer> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
}

