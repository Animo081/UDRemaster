package com.vector.udremaster.controller;

import com.vector.udremaster.entity.User;
import com.vector.udremaster.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/login")
    public void signIn() {

    }

    @PostMapping(value = "/logout")
    public void signOut(Authentication authentication) {
        return;
    }

    @ResponseBody
    @GetMapping(value = "/data")
    public User getUser(@RequestParam("userid") long userId) throws ChangeSetPersister.NotFoundException {
        return userService.getUser(userId);
    }

    @PatchMapping(value = "/update/username")
    public void updateUserUsername(@RequestParam("userid") long userId, @RequestParam("username") String username) throws ChangeSetPersister.NotFoundException {
        userService.setUsernameById(username, userId);
    }

    @PatchMapping(value = "/update/desc")
    public void updateUserDescription(@RequestParam("userid") long userId, @RequestParam("desc") String description) throws ChangeSetPersister.NotFoundException {
        userService.setDescriptionById(description, userId);
    }

    @PatchMapping(value = "/update/email")
    public void updateUserEmail(@RequestParam("userid") long userId, @RequestParam("email") String email) throws ChangeSetPersister.NotFoundException {
        userService.setEmailById(email, userId);
    }

    @PatchMapping(value = "/update/password")
    public void updateUserPassword(@RequestParam("userid") long userId, @RequestParam("oldpassword") String oldPassword,
                                   @RequestParam("newpassword") String newPassword) throws ChangeSetPersister.NotFoundException {
        userService.setPasswordById(oldPassword, newPassword, userId);
    }
}
