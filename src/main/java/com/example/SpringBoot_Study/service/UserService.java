package com.example.SpringBoot_Study.service;

import com.example.SpringBoot_Study.controller.dto.UserSaveRequest;
import com.example.SpringBoot_Study.entity.UserEntity;
import com.example.SpringBoot_Study.repository.UserRepository;
import java.util.ArrayList;
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
        List<UserEntity> userList = userRepository.findAll();

        List<UserEntity> userTwentyList = new ArrayList<>();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getAge() >= 20) {
                userTwentyList.add(userList.get(i));
            }
        }

        return userTwentyList;
    }

    public List<UserEntity> findByAgeGreaterThanEqual() {
        return userRepository.findByAgeGreaterThanEqual(20);
        // 결국 이게 JPA의 이점을 잘 살린 코드이다.
    }

    public List<UserEntity> deleteAgeNegativeService() {
        List<UserEntity> userList = userRepository.findAll();

        for (int i = 0; i < userList.size(); i++){
            if(userList.get(i).getAge() < 0){
                userRepository.deleteById(userList.get(i).getId());
            }
        }

        return userList;
    }

    public List<UserEntity> deleteAgeNegativeRepository(){
        List<UserEntity> userNegative = userRepository.findByAgeLessThan(0);
        userRepository.deleteAll(userNegative);

        // 굳이 userList 에 userRepository 에서 가져와 저장하지 말고 바로 리턴 받으면 됨
        // List<UserEntity> userList = userRepository.findAll();
        return userRepository.findAll();
    }

}
