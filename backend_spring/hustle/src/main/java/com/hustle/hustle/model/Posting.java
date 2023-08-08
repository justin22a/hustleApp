package com.hustle.hustle.model;

public class Posting {
    private String username;
    private String productID;
    private String name;
    private String description;
    private String category;
    private String price;
    private String quantity;
    private String image;
    private String location;
    private String type; // buy or sell 
    private String status; // pending, accepted, rejected, completed
    private String date; // date of posting

    public Posting() {
    }
    
    public Posting(String username, String productID, String name, String description, String category, String price, String quantity, String image, String location, String type, String status, String date) {
        this.username = username;
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.location = location;
        this.type = type;
        this.status = status;
        this.date = date;

    }
    
    public String getUsername() {
        return username;
    }
    
    public String getProductID() {
        return productID;
    }
    
    public String getName() {
        return name;
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
    
    public String getQuantity() {
        return quantity;
    }
    
    public String getImage() {
        return image;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category= category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity= quantity;
    }

    public void setImage(String image) {
        this.image = image;
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


    
    
}
