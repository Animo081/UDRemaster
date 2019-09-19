package com.vector.udremaster.service;

import com.vector.udremaster.entity.User;

public interface UserService {
    long signIn(String login, String password);
    void signUp(String login, String password);
    void signOut();

    User getUser(long userId);

    void setUsername(long userId, String username);
    void setDescription(long userId, String description);
    void setEmail(long userId, String email);
    void setVideoPreview(long userId, long videoId);

    void changePassword(String oldPassword, String newPassword);
}
