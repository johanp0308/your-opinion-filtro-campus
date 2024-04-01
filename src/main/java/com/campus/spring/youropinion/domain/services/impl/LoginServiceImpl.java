package com.campus.spring.youropinion.domain.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campus.spring.youropinion.domain.repositories.UserRepository;
import com.campus.spring.youropinion.domain.security.JWTAuthorizationFilter;
import com.campus.spring.youropinion.domain.security.JWTAuthtenticationConfig;
import com.campus.spring.youropinion.domain.services.LoginService;
import com.campus.spring.youropinion.persistence.dto.UserDto;
import com.campus.spring.youropinion.persistence.entities.UserEntity;


@Service
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;
    
    @Autowired
    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;
    
    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Override
    public UserDto loginUser(String email, String password) {
        UserEntity oUser = userRepository.findByEmailUser(email);
        if (oUser != null) {
            UserEntity userEntity = oUser;
            if(passwordEncoder.matches(password, userEntity.getPassword())){
                String token = jwtAuthtenticationConfig.getJWTToken(userEntity.getEmailUser());
                UserDto userDTO = new UserDto();
                userDTO.setEmail(userEntity.getEmailUser());
                userDTO.setToken(token);
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public UserDto registerUser(String email, String password) {
        UserEntity oUser = userRepository.findByEmailUser(email);
        if(oUser == null){
            UserEntity userEntity = new UserEntity();
            userEntity.setEmailUser(email);
            userEntity.setPassword(passwordEncoder.encode(password));
            UserEntity response = userRepository.save(userEntity); 
            if (response != null) {
                UserDto userDTO = new UserDto();
                userDTO.setEmail(email);
                userDTO.setToken(jwtAuthtenticationConfig.getJWTToken(response.getEmailUser()));
                return userDTO;
            }
        }
        return null;

    }

    @Override
    public Map<String, Object> validateTokeN(String token) {
         boolean valid = false;
        Boolean isJWTValid = jwtAuthorizationFilter.isJWTValid(token);
        if (isJWTValid) {
            String email = jwtAuthorizationFilter.getClaims(token).getSubject();
            UserEntity userEntity = userRepository.findByEmailUser(email);
            if (userEntity != null) {
                valid = true;
            }

        }
        Map<String,Object> repsonse = new HashMap<>();
        repsonse.put("is_token_valid", valid);
        return repsonse;
    }

    @Override
    public UserEntity getUserWToken(String token) {
        Boolean isJWTValid = jwtAuthorizationFilter.isJWTValid(token);
        if (isJWTValid) {
            String email = jwtAuthorizationFilter.getClaims(token).getSubject();
            UserEntity userEntity = userRepository.findByEmailUser(email);
            return userEntity;
        }
        return null;
    }
    
}
