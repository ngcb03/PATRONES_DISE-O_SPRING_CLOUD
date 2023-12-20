package com.springcloud.userservice.controller;

import com.springcloud.userservice.model.User;
import com.springcloud.userservice.model.UserDTO;
import com.springcloud.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> findUsers() {
        return new ResponseEntity<>(
                this.service.findUsers(), HttpStatus.OK
        );
    }

    @GetMapping("/posts/{user_id}")
    public ResponseEntity<UserDTO> findUserWithPosts(@PathVariable Long user_id) {
        return new ResponseEntity<>(
                this.service.findUserWithPosts(user_id),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody User user) {
        this.service.createUser(user);
        return new ResponseEntity<>(
                "¡The user has been created!",
                HttpStatus.CREATED);
    }

}
