package com.campus.spring.youropinion.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.spring.youropinion.domain.services.GenderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("gender")
@SecurityRequirement(name = "bearerAuth")
public class GenderController {
    
    private final GenderService genderService;

    public GenderController(GenderService genderService){
        this.genderService = genderService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllGender() {
        return ResponseEntity.ok().body(genderService.getAllGender());  
    }

    @PostMapping("/")
    public String postMethodName(@RequestBody String entity) {
        
        return entity;
    }
    
    
}
