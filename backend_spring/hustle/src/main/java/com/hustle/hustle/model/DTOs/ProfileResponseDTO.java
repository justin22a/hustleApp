package com.hustle.hustle.model.DTOs;

import java.util.List;

import com.hustle.hustle.model.Posting;
import com.hustle.hustle.model.Product;
import com.hustle.hustle.model.UserProfile;


/**
 * ProfileResponseDTO
 * will be used to send the profile information to the front end
 * will contain the UserProfile information, and the list of postings, and the list of products
 */
public class ProfileResponseDTO {

    private Long userID;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Posting> postings;
    private List<Product> products;

    public ProfileResponseDTO() {
    }

    public ProfileResponseDTO(Long userID, String username, String name, String email, String phoneNumber, List<Posting> postings, List<Product> products) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postings = postings;
        this.products = products;
    }

    public ProfileResponseDTO(UserProfile user, List<Posting> postings, List<Product> products) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.postings = postings;
        this.products = products;
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

    public List<Posting> getPostings() {
        return postings;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPostings(List<Posting> postings){
        this.postings = postings;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    

}