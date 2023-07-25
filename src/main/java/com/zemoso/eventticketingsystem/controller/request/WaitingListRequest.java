package com.zemoso.eventticketingsystem.controller.request;

public class WaitingListRequest {

    private int eventId;
    private int userId;

    public WaitingListRequest() {
    }

    public WaitingListRequest(int eventId, int userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

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

