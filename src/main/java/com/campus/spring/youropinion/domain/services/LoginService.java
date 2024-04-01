package com.campus.spring.youropinion.domain.services;

import java.util.Map;

import com.campus.spring.youropinion.persistence.dto.UserDto;
import com.campus.spring.youropinion.persistence.entities.UserEntity;

public interface LoginService {
    
    UserDto loginUser(String email, String password);
    UserDto registerUser(String email, String password);
    Map<String,Object> validateTokeN(String token);
    UserEntity getUserWToken(String token);
}
