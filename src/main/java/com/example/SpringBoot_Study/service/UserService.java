package com.example.SpringBoot_Study.service;

import com.example.SpringBoot_Study.controller.dto.UserSaveRequest;
import com.example.SpringBoot_Study.entity.UserEntity;
import com.example.SpringBoot_Study.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(Long id, String nickname, int age) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setNickname(nickname);
        userEntity.setAge(age);

        userRepository.save(userEntity);
    }

    public void saveUser2(UserSaveRequest userSaveRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userSaveRequest.getId());
        userEntity.setNickname(userSaveRequest.getNickname());
        userEntity.setAge(userSaveRequest.getAge());

        userRepository.save(userEntity);
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }
}
