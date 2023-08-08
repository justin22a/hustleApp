package com.hustle.hustle.model;

import java.math.BigInteger;

public class Product {
    private String name;
    private String productID;
    private String description;
    private String category;
    private String price;
    private BigInteger quantity;
    private String image;
    private String username;
    private String location;

    public Product(String name, String productID, String description, String category, String price, BigInteger quantity, String image, String username, String location) {
        this.name = name;
        this.productID = productID;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.username = username;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getProductID() {
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
        return username;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductID(String productID) {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    

}
