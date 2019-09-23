package com.vector.udremaster.service;

import com.vector.udremaster.entity.User;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {
    long signIn(String login, String password) throws FailedLoginException;
    void signUp(String login, String password) throws SQLIntegrityConstraintViolationException;
    void signOut();

    boolean existsById(long userId);

    User getUser(long userId);

    void setUsernameById(String username, long userId);
    void setDescriptionById(String description, long userId);
    void setEmailById(String email, long userId);

    void setPasswordById(String oldPassword, String newPassword, long userId);
}
