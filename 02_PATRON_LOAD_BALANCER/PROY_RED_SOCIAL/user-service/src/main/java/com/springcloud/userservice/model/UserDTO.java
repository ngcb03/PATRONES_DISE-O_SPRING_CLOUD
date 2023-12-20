package com.springcloud.userservice.model;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long user_id;
    private String name;
    private String lastname;
    private String cellphone;
    private List<PostDTO> postsList;

}
