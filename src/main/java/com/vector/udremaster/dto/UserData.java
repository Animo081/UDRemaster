package com.vector.udremaster.dto;

public class UserData {

    private long userId;

    private String username;

    private String email;

    private String description;

    public UserData(){

    }

    public UserData(long userId, String username, String email, String description){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
