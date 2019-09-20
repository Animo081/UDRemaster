package com.vector.udremaster.service.impl;

import com.vector.udremaster.entity.User;
import com.vector.udremaster.repository.UserRepository;
import com.vector.udremaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public long signIn(String login, String rawPassword) {

        String encodedPassword = userRepository.getPasswordByLogin(login);

        if (encodedPassword == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No such user");
        if (!passwordEncoder.matches(rawPassword, encodedPassword))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");

        return userRepository.getUserByLogin(login).getUserId();
    }

    @Override
    public void signUp(String login, String password) {
        userRepository.saveAndFlush(new User(login, passwordEncoder.encode(password)));
    }

    @Override
    public void signOut() {

    }

    @Override
    public User getUser(long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void setUsernameById(String username, long userId) {
        userRepository.updateUsernameById(username, userId);
    }

    @Override
    public void setDescriptionById(String description, long userId) {
        userRepository.updateDescriptionById(description, userId);
    }

    @Override
    public void setEmailById(String email, long userId) {
        userRepository.updateEmailById(email, userId);
    }

    @Override
    public void setVideoPreviewById(long videoId, long userId) {
        userRepository.updateVideoPreviewIdByUserId(videoId, userId);
    }

    @Override
    public void setPasswordById(String oldPassword, String newPassword, long userId) {

        String encodedPassword = userRepository.getPasswordById(userId);

        if (encodedPassword == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id ("+userId+")");
        if (!passwordEncoder.matches(oldPassword, encodedPassword))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");

        userRepository.updatePasswordById(passwordEncoder.encode(newPassword), userId);
    }
}
