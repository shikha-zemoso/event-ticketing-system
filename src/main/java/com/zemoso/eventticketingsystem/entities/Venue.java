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

    // Constructors, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int venue_id) {
        this.id = venue_id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venue_name) {
        this.venueName = venue_name;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venue_address) {
        this.venueLocation = venue_address;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int venue_capacity) {
        this.seatingCapacity = venue_capacity;
    }
}
