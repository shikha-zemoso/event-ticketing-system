package com.zemoso.eventticketingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket ticket;

    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "purchase_quantity")
    private int purchaseQuantity;

    public Purchase(User user, Ticket ticket, Date purchaseDate, int purchaseQuantity) {
        this.user = user;
        this.ticket = ticket;
        this.purchaseDate = purchaseDate;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Purchase() {

    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

}
