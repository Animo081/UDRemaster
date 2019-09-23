package com.vector.udremaster.dto;

public class UserId {

    private long userId;

    public UserId() {}

    public UserId(long userId) {
        this.userId = userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
