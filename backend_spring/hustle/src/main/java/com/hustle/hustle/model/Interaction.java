package com.hustle.hustle.model;

import java.math.BigInteger;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Interaction {
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userId")
    private UserProfile user;
    private String category;
    private BigInteger quantity;


    public Interaction() {
    }

    public Interaction(UserProfile user, String category, BigInteger quantity) {
        this.user = user;
        this.category = category;
        this.quantity = quantity;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getCategory(){
        return category;
    }

    public BigInteger getQuantity(){
        return quantity;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }



}
