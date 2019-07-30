package com.watercorp.graphqlapi.controllers;

import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User saved = userRepository.save(user);
        return ResponseEntity.ok(saved);
    }
}
