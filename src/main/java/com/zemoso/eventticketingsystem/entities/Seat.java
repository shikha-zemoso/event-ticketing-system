package com.zemoso.eventticketingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Event event;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "is_booked")
    private boolean isBooked;

    // Constructors, getters, and setters

    public Seat() {
    }

    public Seat(Event event, int seatNumber) {
        this.event = event;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }
    public int getId() {
        return id;
    }

    public void setId(int seat_id) {
        this.id = seat_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seat_number) {
        this.seatNumber = seat_number;
    }

    public boolean isIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean is_booked) {
        this.isBooked = is_booked;
    }
}
