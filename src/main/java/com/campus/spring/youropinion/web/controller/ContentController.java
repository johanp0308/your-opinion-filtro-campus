package com.campus.spring.youropinion.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.campus.spring.youropinion.domain.services.ContentService;
import com.campus.spring.youropinion.persistence.dto.ContentDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("content")
@SecurityRequirement(name = "bearerAuth")
public class ContentController {

    
    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }
    
    @PostMapping("/")
    public ResponseEntity<Object> postMethodName(@RequestBody ContentDTO contentDTO) {
        return contentService.saveContent(contentDTO);
    }
    
}
