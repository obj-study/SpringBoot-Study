package com.example.SpringBoot_Study.controller;

import com.example.SpringBoot_Study.controller.dto.UserSaveRequest;
import com.example.SpringBoot_Study.entity.UserEntity;
import com.example.SpringBoot_Study.repository.UserRepository;
import com.example.SpringBoot_Study.service.UserService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // query params
    @PostMapping("/save")
    public void save(
            @RequestParam Long id,
            @RequestParam String nickname,
            @RequestParam int age
    ){
          userService.saveUser(id, nickname, age);
    }

    // request body
    @PostMapping("/save/v2")
    public void save2(
        @RequestBody UserSaveRequest userSaveRequest
    ) {
        userService.saveUser2(userSaveRequest);
    }


    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAllUser();
    }

    @GetMapping("/one/{uid}")
    public UserEntity findOne(
            @PathVariable Long uid
    ) {
        return userService.findUser(uid);
    }




//    @GetMapping("/delete")
//    public void delete(){
//        Long id = 2L;
//        String nickname = "복지민";
//        int age = 24;
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(id);
//        userEntity.setNickname(nickname);
//        userEntity.setAge(age);
//
//        userRepository.delete(userEntity);
//    }
}
