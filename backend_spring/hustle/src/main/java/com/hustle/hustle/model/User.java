package com.hustle.hustle.model;

import jakarta.persistence.Column;

public class User {
    @Column(unique = true)
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    
    public User() {
    }

    public User(String username, String name, String email, String phoneNumber) {

        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

}
