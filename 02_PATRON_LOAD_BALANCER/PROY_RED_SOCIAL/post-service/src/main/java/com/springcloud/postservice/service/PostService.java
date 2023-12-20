package com.springcloud.postservice.service;

import com.springcloud.postservice.model.Post;
import com.springcloud.postservice.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository repository;

    @Override
    public List<Post> findPosts() {
        return this.repository.findAll();
    }

    @Override
    public List<Post> findPostsByUser(Long user_id) {
        return this.repository.findPostByUser(user_id);
    }

    @Override
    public void createPost(Post post) {
        this.repository.save(post);
    }

}
