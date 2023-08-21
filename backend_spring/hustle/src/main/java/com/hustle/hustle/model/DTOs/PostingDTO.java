package com.hustle.hustle.model.DTOs;

import com.hustle.hustle.model.Product;

// change this to a DTO that displays the posting and the comments associated with it when a user clicks on a posting
public class PostingDTO {
    private Long postingID;
    private String title;
    private String description;
    private String category;
    private String location;
    private String price;
    private String datePosted;
    private String dateSold;
    private String status;
    private String image;
    private Long userID;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private Product product;
    

    public PostingDTO() {
    }

    public PostingDTO(Long postingID, String title, String description, String category, String location, String price, String datePosted, String dateSold, String status, String image, Long userID, String username, String name, String email, String phoneNumber, Product product) {
        this.postingID = postingID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.price = price;
        this.datePosted = datePosted;
        this.dateSold = dateSold;
        this.status = status;
        this.image = image;
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.product = product;
    }

    public Long getPostingID() {
        return postingID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public String getDateSold() {
        return dateSold;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public Long getUserID() {
        return userID;
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

    public Product getProduct() {
        return product;
    }

    public void setPostingID(Long postingID) {
        this.postingID = postingID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}