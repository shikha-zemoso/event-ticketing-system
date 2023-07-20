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

    // Constructors, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int event_id) {
        this.id = event_id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String event_name) {
        this.eventName = event_name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date event_date) {
        this.eventDate = event_date;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String event_description) {
        this.eventDescription = event_description;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
