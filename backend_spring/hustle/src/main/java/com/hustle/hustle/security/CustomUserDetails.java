package com.hustle.hustle.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.hustle.hustle.model.UserProfile;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CustomUserDetails extends User {

    private Long userID;
    private String name;
    private String email;
    private String phoneNumber;

    public CustomUserDetails(Long userID, String username, String password,
                             String name, String email, String phoneNumber) {
        super(username, password, new ArrayList<>());
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public CustomUserDetails(UserProfile user) {
        super(user.getUsername(), user.getPassword(), new ArrayList<>());
        this.userID = user.getUserID();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }

    public Long getUserID() {
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

    public UserProfile getUser() {
        return new UserProfile(userID, getUsername(), name, email, phoneNumber);
    }
}

