package com.zemoso.eventticketingsystem.controller.request;

public class WaitingListRequest {

    private int eventId;
    private int userId;

    public WaitingListRequest(int eventId, int userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getUserId() {
        return userId;
    }

}

