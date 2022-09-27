package com.kata.social.mediakata.webapp.controller.user;

import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<String> userPage() {
       return new ResponseEntity<>("users", HttpStatus.OK);
    }


    @GetMapping("/admin")
    public ResponseEntity<User> adminPage() {
        return new ResponseEntity<>(userService.getById((long) 1).get(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<String> allPage() {
        return new ResponseEntity<>("all", HttpStatus.OK);
    }
}
