package com.hustle.hustle.model;

import java.math.BigInteger;

public class Posting {
    private Product product;
    private String type; // buy or sell 
    private String status; // pending, accepted, rejected, completed
    private String date; // date of posting

    public Posting() {
    }
    
    public Posting(Product p, String type, String status, String date) {
        this.product = p;
        this.type = type;
        this.status = status;
        this.date = date;

    }
    
    public String getUsername() {
        return product.getUsername();
    }
    
    public Long getProductID() {
        return product.getProductID();
    }
    
    public String getName() {
        return product.getName();
    }
    
    public String getDescription() {
        return product.getDescription();
    }
    
    public String getCategory() {
        return product.getCategory();
    }
    
    public String getPrice() {
        return product.getPrice();
    }
    
    public BigInteger getQuantity() {
        return product.getQuantity();
    }
    
    public String getImage() {
        return product.getImage();
    }
    
    public String getLocation() {
        return product.getLocation();
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setLocation(String location) {
        product.setLocation(location);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status= status;
    }

    public void setDate(String date) {
        this.date = date;
    }


    
    
}
