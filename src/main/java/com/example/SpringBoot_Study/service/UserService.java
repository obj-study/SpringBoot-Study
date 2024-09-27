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

        UserEntity userEntity = new UserEntity(id, nickname, age);

        userRepository.save(userEntity);
    }

    public void saveUser2(UserSaveRequest userSaveRequest) {

        // UserSaveRequest -> UserEntity

        UserEntity user = userSaveRequest.toEntity();

        userRepository.save(user);
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    public UserEntity findUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity updateNickname(Long id) {

        UserEntity user = userRepository.findById(id).get();

        user.updateNickname("바뀐 닉네임");

        return userRepository.save(user);
    }

    public List<UserEntity> findAgeTwentyService() {
        List<UserEntity> userAgeTwenty =  userRepository.findAll();
        if()

    }
}
