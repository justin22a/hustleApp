package com.hustle.hustle.model;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;
    @OneToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product product;
    private List<String> category;
    private String postDescription;
    private String type; // buy or sell 
    private String status; // pending, accepted, rejected, completed
    private String date; // date of posting
    private String endDate; // date of completion
    private String location;

    public Posting() {
    }
    
    //sell posting
    public Posting(Product p, String type, String status, String date, String postDescription, String endDate) {
        this.product = p;
        this.type = type;
        this.status = status;
        this.date = date;
        this.category = p.getCategory();
        this.postDescription = postDescription;
        this.location = p.getLocation();
        this.endDate = endDate;
    }

    //buy posting
    public Posting(String type, String status, String date, List<String> category, String postDescription, String location, String endDate) {   
        this.type = type;
        this.status = status;
        this.date = date;
        this.category = category;
        this.postDescription = postDescription;
        this.location = location;
        this.endDate = endDate;
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
    
    public List<String> getCategory() {
        return category;
    }
    
    public BigDecimal getPrice() {
        return product.getPrice();
    }
    
    public BigInteger getQuantity() {
        return product.getQuantity();
    }
    
    public String getImage() {
        return product.getImage();
    }
    
    public String getLocation() {
        return location;
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

    public String getEndDate() {
        return endDate;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }


    
    
}
