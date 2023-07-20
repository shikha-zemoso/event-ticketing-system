package com.zemoso.eventticketingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity(name = "Waiting_List")
public class WaitingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;

    @Column(name = "join_date")
    private Date joinDate;

    public WaitingList(Event event, User user, Date joinDate) {
        this.event = event;
        this.user = user;
        this.joinDate = joinDate;
    }

    public WaitingList() {

    }

    // Constructors, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int waitingList_id) {
        this.id = waitingList_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date join_date) {
        this.joinDate = join_date;
    }
}
