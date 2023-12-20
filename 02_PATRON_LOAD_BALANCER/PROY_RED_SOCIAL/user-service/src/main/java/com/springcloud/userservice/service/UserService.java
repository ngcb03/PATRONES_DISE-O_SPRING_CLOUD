package com.springcloud.userservice.service;

import com.springcloud.userservice.model.PostDTO;
import com.springcloud.userservice.model.User;
import com.springcloud.userservice.model.UserDTO;
import com.springcloud.userservice.repository.IPostApiClient;
import com.springcloud.userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired

    private IUserRepository repository;
    @Autowired
    private IPostApiClient postApi;

    @Override
    public List<User> findUsers() {
        return this.repository.findAll();
    }

    @Override
    public UserDTO findUserWithPosts(Long user_id) {

        // Datos usuario desde BD
        User user = this.repository.findById(user_id).orElse(null);

        // Posts usuario desde servicio Posts
        List<PostDTO> postsList = this.postApi.findPostsByUser(user_id);

        // Unificamos Datos usuario con Posts en UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setName(user.getName());
        userDTO.setLastname(user.getLastname());
        userDTO.setCellphone(user.getCellphone());
        userDTO.setPostsList(postsList);

        // retornamos entidad con datos unificados
        return userDTO;
    }

    @Override
    public void createUser(User user) {
        this.repository.save(user);
    }

}
