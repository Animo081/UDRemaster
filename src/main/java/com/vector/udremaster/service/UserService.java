package com.vector.udremaster.service;

import com.vector.udremaster.dto.UserData;
import com.vector.udremaster.entity.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {
    long signIn(String login, String password) throws FailedLoginException, ChangeSetPersister.NotFoundException;
    void signUp(String login, String password) throws SQLIntegrityConstraintViolationException;

    boolean existsById(long userId);

    User getUser(long userId) throws ChangeSetPersister.NotFoundException;

    void setUserData(UserData userData) throws ChangeSetPersister.NotFoundException;

    void setPasswordById(String oldPassword, String newPassword, long userId) throws ChangeSetPersister.NotFoundException;
}
