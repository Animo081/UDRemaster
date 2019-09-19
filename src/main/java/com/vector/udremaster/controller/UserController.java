package com.vector.udremaster.controller;

import com.vector.udremaster.entity.Playlist;
import com.vector.udremaster.entity.PlaylistId;
import com.vector.udremaster.repository.PlaylistRepository;
import com.vector.udremaster.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PlaylistRepository playlistRepository;
/*
    @Autowired
    PasswordEncoder passwordEncoder;


 */
    @GetMapping
    public void showDefault(@RequestParam("login") String login, @RequestParam("password") String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        userService.signUp(login, myHash);
    }

    @GetMapping("/login")
    public void getDefault(@RequestParam("login") String login, @RequestParam("password") String password){
        userService.signIn(login, password);
    }

    @GetMapping("/pl")
    public void addPlaylist(@RequestParam("user") long user, @RequestParam("audio") long audio){
        playlistRepository.saveAndFlush(new Playlist(new PlaylistId(user, audio)));
    }
}
