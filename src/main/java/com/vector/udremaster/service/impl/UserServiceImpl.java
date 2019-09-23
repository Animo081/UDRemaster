package com.vector.udremaster.service.impl;

import com.vector.udremaster.entity.User;
import com.vector.udremaster.repository.UserRepository;
import com.vector.udremaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public long signIn(String login, String rawPassword) throws ChangeSetPersister.NotFoundException {

        User user = userRepository.findByLogin(login).orElseThrow(ChangeSetPersister.NotFoundException::new);

        if (!passwordEncoder.matches(rawPassword, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");

        return user.getUserId();
    }

    @Override
    public void signUp(String login, String password) {
        userRepository.saveAndFlush(new User(login, passwordEncoder.encode(password)));
    }

    @Override
    public void signOut() {

    }

    @Override
    public boolean existsById(long userId){
        return userRepository.existsById(userId);
    }

    @Override
    public User getUser(long userId) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(userId).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public void setUsernameById(String username, long userId) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        user.setUsername(username);
        userRepository.save(user);
    }

    @Override
    public void setDescriptionById(String description, long userId) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        user.setDescription(description);
        userRepository.save(user);
    }

    @Override
    public void setEmailById(String email, long userId) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        user.setEmail(email);
        userRepository.save(user);
    }

    @Override
    public void setPasswordById(String oldPassword, String newPassword, long userId) throws ChangeSetPersister.NotFoundException {

        User user = userRepository.findById(userId).orElseThrow(ChangeSetPersister.NotFoundException::new);

        if (!passwordEncoder.matches(oldPassword, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
