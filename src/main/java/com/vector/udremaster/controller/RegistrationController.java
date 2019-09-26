package com.vector.udremaster.controller;

import com.vector.udremaster.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public void signUp(@RequestParam("login") String login, @RequestParam("password") String password){
        userService.signUp(login, password);
    }
}
