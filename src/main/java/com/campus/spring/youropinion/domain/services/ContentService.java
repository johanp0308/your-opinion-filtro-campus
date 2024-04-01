package com.campus.spring.youropinion.domain.services;

import org.springframework.http.ResponseEntity;

import com.campus.spring.youropinion.persistence.dto.ContentDTO;

public interface ContentService {
    
    ResponseEntity<Object> saveContent(ContentDTO cDto);
    
}
