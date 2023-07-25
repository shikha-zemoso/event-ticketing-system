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

    public void setId(int purchaseId) {
        this.id = purchaseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}
