package com.example.SpringBoot_Study.repository;

import com.example.SpringBoot_Study.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
