package com.example.SpringBoot_Study.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity // JPA를 이용해서 이걸 영속성 객체로 쓰겠다. 데이터베이스에 저장하겠다?
@Table(name = "user")   // Entity가 매핑될 테이블을 지정
@Setter
public class UserEntity {
    @Id
    private Long id;

    //@Column(name = "nickname") 이름을 똑같이 사용 시 생략 가능
    private String nickname;

    private Integer age;

}
