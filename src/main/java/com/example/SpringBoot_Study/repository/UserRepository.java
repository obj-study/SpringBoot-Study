package com.example.SpringBoot_Study.repository;

import com.example.SpringBoot_Study.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByAgeGreaterThanEqual(int age);
    // SQL로는 select * from user where age >= ?;

    List<UserEntity> findByAgeLessThan(int age);

}
