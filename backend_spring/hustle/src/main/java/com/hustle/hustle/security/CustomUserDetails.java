package com.hustle.hustle.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CustomUserDetails extends User {

    private BigInteger userID;
    private String name;
    private String email;
    private String phoneNumber;

    public CustomUserDetails(BigInteger userID, String username, String password,
                             String name, String email, String phoneNumber) {
        super(username, password, new ArrayList<>());
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BigInteger getUserID() {
        return userID;
    }
 // has getUserName() and getPassword() from User class
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public com.hustle.hustle.model.User getUser() {
        com.hustle.hustle.model.User user = new com.hustle.hustle.model.User(userID, getUsername(), name, email, phoneNumber);
        return user;
    }
}

