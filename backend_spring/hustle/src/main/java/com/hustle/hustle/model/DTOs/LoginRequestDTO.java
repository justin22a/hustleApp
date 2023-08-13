package com.hustle.hustle.model.DTOs;

public class LoginRequestDTO {

    private String username;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(){
        this.username = username;
    }

    public void setPassword(){
        this.password = password;
    }

}
