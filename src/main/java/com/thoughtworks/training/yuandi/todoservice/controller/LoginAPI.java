package com.thoughtworks.training.yuandi.todoservice.controller;

import com.thoughtworks.training.yuandi.todoservice.model.User;
import com.thoughtworks.training.yuandi.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginAPI {
    private final UserService userService;

    @Autowired
    public LoginAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String login(@RequestBody User user) {
        if (userService.verify(user)){
            return userService.generateToken(user.getUsername());
        }
        return null;
    }
}
