package com.springcloud.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Basic
    private String name;
    private String lastname;
    private String cellphone;

}
