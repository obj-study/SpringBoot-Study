package com.example.SpringBoot_Study.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Table
@Setter
public class UserEntity {
    @Id
    private Long id;

    //@Column(name = "nickname")
    private String nickname;

    private Integer age;
}
