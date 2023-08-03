package com.zemoso.eventticketingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Event event;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "is_booked")
    private boolean isBooked;

    public Seat() {
    }

    public Seat(Event event, int seatNumber) {
        this.event = event;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public Seat(int id, Event event, int seatNumber, boolean isBooked) {
        this.id = id;
        this.event = event;
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int seatId) {
        this.id = seatId;
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

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}
