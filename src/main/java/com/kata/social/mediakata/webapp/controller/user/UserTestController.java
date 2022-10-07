package com.kata.social.mediakata.webapp.controller.user;

import com.kata.social.mediakata.model.entity.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserTestController {
    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") long userId) {
        return null;
    }
}

