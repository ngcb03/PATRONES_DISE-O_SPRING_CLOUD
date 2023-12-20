package com.springcloud.postservice.service;

import com.springcloud.postservice.model.Post;

import java.util.List;

public interface IPostService {

    public List<Post> findPosts();
    public List<Post> findPostsByUser(Long user_id);
    public void createPost(Post post);

}
