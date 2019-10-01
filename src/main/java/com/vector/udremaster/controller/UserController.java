package com.vector.udremaster.controller;

import com.vector.udremaster.dto.UserData;
import com.vector.udremaster.entity.User;
import com.vector.udremaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void signUp(@RequestParam("login") String login, @RequestParam("password") String password)
            throws SQLIntegrityConstraintViolationException {
        userService.signUp(login, password);
    }

    @ResponseBody
    @GetMapping(value = "/login")
    public long signIn(@RequestParam("login") String login, @RequestParam("password") String password)
            throws ChangeSetPersister.NotFoundException, FailedLoginException {
        return userService.signIn(login, password);
    }

    @PostMapping(value = "/logout")
    public void signOut() {
    }

    @ResponseBody
    @GetMapping(value = "/data")
    public User getUser(@RequestParam("userid") long userId)
            throws ChangeSetPersister.NotFoundException {
        return userService.getUser(userId);
    }

    @PutMapping(value = "/update")
    public void setUser(@RequestBody UserData userData)
            throws ChangeSetPersister.NotFoundException {
        userService.setUserData(userData);
    }
}
