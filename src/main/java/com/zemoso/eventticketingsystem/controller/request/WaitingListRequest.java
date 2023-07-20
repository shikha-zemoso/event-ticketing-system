package com.zemoso.eventticketingsystem.controller.request;

public class WaitingListRequest {

    private int eventId;
    private int userId;

    // Add any additional fields and methods as needed

    // Default constructor (required for JSON serialization/deserialization)
    public WaitingListRequest() {
    }

    public WaitingListRequest(int eventId, int userId) {
        this.eventId = eventId;
        this.userId = userId;
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
}

