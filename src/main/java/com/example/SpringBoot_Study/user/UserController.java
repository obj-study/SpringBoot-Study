package com.example.SpringBoot_Study.user;

import com.example.SpringBoot_Study.entity.UserEntity;
import com.example.SpringBoot_Study.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/info")
    public void info(){
        Long id = 1L;
        String nickname = "홍길동";
        int age = 20;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setNickname(nickname);
        userEntity.setAge(age);

        userRepository.save(userEntity);

    }

}
