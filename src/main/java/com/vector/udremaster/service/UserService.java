package com.vector.udremaster.service;

import com.vector.udremaster.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {
    long signIn(String login, String password) throws FailedLoginException, ChangeSetPersister.NotFoundException;
    void signUp(String login, String password) throws SQLIntegrityConstraintViolationException;
    void signOut();

    boolean existsById(long userId);

    User getUser(long userId) throws ChangeSetPersister.NotFoundException;

    void setUsernameById(String username, long userId) throws ChangeSetPersister.NotFoundException;
    void setDescriptionById(String description, long userId) throws ChangeSetPersister.NotFoundException;
    void setEmailById(String email, long userId) throws ChangeSetPersister.NotFoundException;

    void setPasswordById(String oldPassword, String newPassword, long userId) throws ChangeSetPersister.NotFoundException;
}
