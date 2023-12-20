package com.springcloud.postservice.controller;

import com.springcloud.postservice.model.Post;
import com.springcloud.postservice.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService service;

    // podemos establecer valores de application.properties
    @Value("${server.port}")
    private int server_port;

    @GetMapping("/")
    public ResponseEntity<List<Post>> findPosts() {
        return new ResponseEntity<>(
                this.service.findPosts(),
                HttpStatus.OK
        );
    }

    @GetMapping("/find-by-user/{user_id}")
    public ResponseEntity<List<Post>> findPostsByUser(
            @PathVariable("user_id") Long user_id) {
        System.out.println("----------- I´m in the port " + server_port);
        return new ResponseEntity<>(
                this.service.findPostsByUser(user_id),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        this.service.createPost(post);
        return new ResponseEntity<>(
                "¡The post has been created!",
                HttpStatus.CREATED);
    }


}
