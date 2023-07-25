package com.zemoso.eventticketingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    private Event event;

    @Column(name = "ticket_price")
    private double ticketPrice;

    @Column(name = "ticket_type")
    private String ticketType; // like Gold, Silver and Platinum.
    @Column(name = "ticket_quantity")
    private int ticketQuantity; // current available ticket quantity

    public Ticket(Event event, double ticketPrice, String ticketType, int ticketQuantity) {
        this.event = event;
        this.ticketPrice = ticketPrice;
        this.ticketType = ticketType;
        this.ticketQuantity = ticketQuantity;
    }

    public Ticket() {

    }

    public Ticket(int id, Event event, double ticketPrice, String ticketType, int ticketQuantity) {
        this.id = id;
        this.event = event;
        this.ticketPrice = ticketPrice;
        this.ticketType = ticketType;
        this.ticketQuantity = ticketQuantity;
    }

    // Constructors, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int ticketId) {
        this.id = ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
}
