package com.example.SpringBoot_Study.controller.dto;

import com.example.SpringBoot_Study.entity.UserEntity;

public class UserSaveRequest {
    private Long id;
    private String nickname;
    private int age;

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public UserEntity toEntity() {
        return new UserEntity(id, nickname, age);
    }
}
