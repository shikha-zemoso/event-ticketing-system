package com.zemoso.eventticketingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_date")
    private Date eventDate;
    @Column(name = "event_description")
    private String eventDescription;

    @ManyToOne
    private Venue venue;

    public Event() {
    }

    public Event(int id, String eventName, Date eventDate, String eventDescription, Venue venue) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.venue = venue;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public Venue getVenue() {
        return venue;
    }

}
