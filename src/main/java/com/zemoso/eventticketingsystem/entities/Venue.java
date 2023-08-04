package com.zemoso.eventticketingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "venue_name")
    private String venueName;
    @Column(name = "venue_location")
    private String venueLocation;
    @Column(name = "seating_capacity")
    private int seatingCapacity;

    public Venue(int venueId, String venueName, String venueLocation) {
        this.id = venueId;
        this.venueName = venueName;
        this.venueLocation = venueLocation;
    }

    public Venue() {
    }


    public int getId() {
        return id;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

}
