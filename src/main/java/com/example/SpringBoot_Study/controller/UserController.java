package com.example.SpringBoot_Study.controller;

import com.example.SpringBoot_Study.controller.dto.UserSaveRequest;
import com.example.SpringBoot_Study.entity.UserEntity;
import com.example.SpringBoot_Study.repository.UserRepository;
import com.example.SpringBoot_Study.service.UserService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    /**
     * Create
     */
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


    /**
     * Read
     */
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


    /**
     * Delete
     */
    @DeleteMapping("/delete/{uid}")
    public void deleteOne(
            @PathVariable Long uid
    ) {
        userService.deleteUser(uid);
    }


    /**
     * Update
     */
    @PutMapping("/update/{uid}")
    public UserEntity updateUser(
            @PathVariable Long uid
    ) {
        return userService.updateNickname(uid);
    }


    // TODO : 나이가 20살 이상인 유저들만 조회하는 API 구현하기

    // Service 에서 필터링
    @GetMapping("/age/twenty/service")
    public List<UserEntity> findAge() {
        return userService.findAgeTwentyService();
    }

    // Repository 에서 필터링
    @GetMapping("/age/twenty/repository")
    public List<UserEntity> findAge2() {
        return userService.findByAgeGreaterThanEqual();
    }


    // TODO : 나이가 음수인 유저들을 삭제하는 API 구현하기

    // Service 에서 필터링 후 삭제
    @GetMapping("/age/negative/delete/service")
    public List<UserEntity> deleteAgeNegativeDeleteService() {
        return userService.deleteAgeNegativeService();
    }

    @GetMapping("/age/negative/delete/repository")
    public List<UserEntity> deleteAgeNegativeDeleteRepository() {
        return userService.deleteAgeNegativeRepository();
    }

}
