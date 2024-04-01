package com.campus.spring.youropinion.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.campus.spring.youropinion.domain.excepciones.UserNotFoundException;
import com.campus.spring.youropinion.domain.services.LoginService;
import com.campus.spring.youropinion.persistence.dto.UserDto;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SecurityRequirement(name = "bearerAuth")
public class LoginController {
    
    @Autowired
    private LoginService loginService;


    @PostMapping("login")
    public ResponseEntity<?> loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password){
        UserDto userDTO = loginService.loginUser(email, password);
        if (userDTO == null) {
            throw new UserNotFoundException("This user: "+email+" Does not exist");
        }
        return ResponseEntity.ok().body(userDTO);
    }
    
    @PostMapping("registerUser")
    public ResponseEntity<?> registerUser(
            @RequestParam("email") String username,
            @RequestParam("password") String password) {
        UserDto userDTO = loginService.registerUser(username, password);
        if(userDTO == null){
            throw new UserNotFoundException("User not created");
        }
        return ResponseEntity.ok().body(userDTO);
    }
    
    @PostMapping("validateToken")
    public ResponseEntity<?> validateToken(@RequestParam("token") String token) {
        Map<String,Object> tokenMap = loginService.validateTokeN(token);
        return ResponseEntity.ok().body(tokenMap);
    }

}
