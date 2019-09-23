package com.vector.udremaster.controller;

import com.vector.udremaster.entity.User;
import com.vector.udremaster.service.impl.UserServiceImpl;
import com.vector.udremaster.dto.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public void signUp(@RequestParam("login") String login, @RequestParam("password") String password){
        userService.signUp(login, password);
    }

    @ResponseBody
    @GetMapping(value = "/login", produces = "application/json")
    public UserId signIn(@RequestParam("login") String login, @RequestParam("password") String password)
            throws FailedLoginException {
        return new UserId(userService.signIn(login, password));
    }

    @PostMapping(value = "/logout")
    public void signOut(){
        userService.signOut();
    }

    @ResponseBody
    @GetMapping(value = "/data")
    public User getUser(@RequestParam("userid") long userId){
        return userService.getUser(userId);
    }

    @PatchMapping(value = "/update/username")
    public void updateUserUsername(@RequestParam("userid") long userId, @RequestParam("username") String username){
        userService.setUsernameById(username, userId);
    }

    @PatchMapping(value = "/update/desc")
    public void updateUserDescription(@RequestParam("userid") long userId, @RequestParam("desc") String description){
        userService.setDescriptionById(description, userId);
    }

    @PatchMapping(value = "/update/email")
    public void updateUserEmail(@RequestParam("userid") long userId, @RequestParam("email") String email){
        userService.setEmailById(email, userId);
    }

    @PatchMapping(value = "/update/password")
    public void updateUserPassword(@RequestParam("userid") long userId, @RequestParam("oldpassword") String oldPassword,
                                   @RequestParam("newpassword") String newPassword){
        userService.setPasswordById(oldPassword, newPassword, userId);
    }
}
