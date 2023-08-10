package com.hustle.hustle.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class User {
    @Column(unique = true)
    private BigInteger userID;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    public User() {
    }

    public User(BigInteger userID, String username, String name, String email, String phoneNumber) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BigInteger getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserID(BigInteger userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name; 
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

}
