package com.example.SpringBoot_Study.controller.dto;

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
}
