package com.zemoso.eventticketingsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_phone")
    private String userPhone;

    public User() {
    }

    public User(int id, String userName, String userEmail, String userPhone) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }

    public String getUserName() {
        return userName;
    }


    public String getUserEmail() {
        return userEmail;
    }


    public String getUserPhone() {
        return userPhone;
    }

}
