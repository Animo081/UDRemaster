package com.vector.udremaster.service.impl;

import com.vector.udremaster.entity.User;
import com.vector.udremaster.repository.UserRepository;
import com.vector.udremaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long signIn(String login, String password) {

        User user = userRepository.getUserByLoginAndPassword(login, password);
        return user.getUserId();
    }

    @Override
    public void signUp(String login, String password) {
        userRepository.saveAndFlush(new User(login, password));
    }

    @Override
    public void signOut() {

    }

    @Override
    public User getUser(long userId) {
        return null;
    }

    @Override
    public void setUsername(long userId, String username) {

    }

    @Override
    public void setDescription(long userId, String description) {

    }

    @Override
    public void setEmail(long userId, String email) {

    }

    @Override
    public void setVideoPreview(long userId, long videoId) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }
}
