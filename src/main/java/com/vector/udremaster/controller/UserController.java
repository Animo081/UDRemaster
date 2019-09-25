package com.vector.udremaster.controller;

import com.vector.udremaster.dto.UserId;
import com.vector.udremaster.entity.User;
import com.vector.udremaster.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public void signUp(@RequestParam("login") String login, @RequestParam("password") String password){
        userService.signUp(login, password);
    }

    @GetMapping(value = "/login")
    public UserId signIn(@RequestParam("login") String login, @RequestParam("password") String password)
            throws ChangeSetPersister.NotFoundException {
         return new UserId(userService.signIn(login, password));
    }

    @PostMapping(value = "/logout")
    public void signOut() {
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
