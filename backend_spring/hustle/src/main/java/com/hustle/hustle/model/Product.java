package com.hustle.hustle.model;

import java.math.BigInteger;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;


public class Product {
    @NotEmpty
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    @Lob
    private String description;
    private String category;
    private String price;
    private BigInteger quantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
    private String location;

    public Product() {
    }

    public Product(String name, Long productID, String description, String category, String price, BigInteger quantity, String image, User user, String location) {
        this.name = name;
        this.productID = productID;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.user = user;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Long getProductID() {
        return productID;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setLocation(String location) {
        this.location = location;
    }



}
