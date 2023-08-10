package com.hustle.hustle.model;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;


public class Product {
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    @Lob
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    private List<String> category;
    @NotEmpty(message = "Price cannot be empty")
    private BigDecimal price;
    @NotEmpty(message = "Quantity cannot be empty")
    private BigInteger quantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;
    @NotEmpty(message = "Location cannot be empty")
    private String location;

    public Product() {
    }

    public Product(String name, Long productID, String description, List<String> category, BigDecimal price, BigInteger quantity, String image, User user, String location) {
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

    public List<String> getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
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

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
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
