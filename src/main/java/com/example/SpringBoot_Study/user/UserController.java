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

    // 의존성 주입 - 생성자를 통한 의존성 주입
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 메서드1 -> API 하나
    // get요청 인데 /user/info로 요청이 들어오면
    @GetMapping("/info")
    public void info(){
        Long id = 1L;
        String nickname = "홍길동";
        int age = 20;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setNickname(nickname);
        userEntity.setAge(age);

        // 저장 로직
        userRepository.save(userEntity);    // select와 insert를 같이 해줌

    }

}
