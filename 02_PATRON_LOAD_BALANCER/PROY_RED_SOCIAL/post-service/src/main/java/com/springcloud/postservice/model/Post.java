package com.springcloud.postservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "posts")
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long post_id;
    @Basic
    private String title;
    private Long user_id;

}
