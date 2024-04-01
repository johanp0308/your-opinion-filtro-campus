package com.campus.spring.youropinion.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.spring.youropinion.persistence.entities.UserEntity;
import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity,Long>{
    UserEntity findByEmailUser(String emailUser);
}
