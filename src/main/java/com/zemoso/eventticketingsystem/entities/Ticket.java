package com.zemoso.eventticketingsystem.entities;

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

    // Constructors, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int ticket_id) {
        this.id = ticket_id;
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

    public void setTicketPrice(double ticket_price) {
        this.ticketPrice = ticket_price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticket_type) {
        this.ticketType = ticket_type;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(int ticket_quantity) {
        this.ticketQuantity = ticket_quantity;
    }
}
