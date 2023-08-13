package com.hustle.hustle.model.DTOs;


/**
 * RegistrationRequestDTO
 * hold the data for a registration request
 */
public class RegistrationRequestDTO {
    
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String name;

    public RegistrationRequestDTO() {
    }

    public RegistrationRequestDTO(String username, String password, String email, String phoneNumber, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getName(){
        return name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegistrationRequestDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
