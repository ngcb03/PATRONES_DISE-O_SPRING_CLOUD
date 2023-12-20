package com.springcloud.userservice.service;

import com.springcloud.userservice.model.PostDTO;
import com.springcloud.userservice.model.User;
import com.springcloud.userservice.model.UserDTO;

import java.util.List;

public interface IUserService {

    public List<User> findUsers();
    public UserDTO findUserWithPosts(Long user_id);
    public void createUser(User user);

}
