package com.springcloud.userservice.model;

import lombok.Data;
@Data
public class PostDTO {

    private Long post_id;
    private String title;
    private Long user_id;

}
