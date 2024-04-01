package com.campus.spring.youropinion.domain.services;

import java.util.List;

import com.campus.spring.youropinion.persistence.dto.GenderDTO;

public interface GenderService {
    List<GenderDTO> getAllGender();
    GenderDTO saveGender(GenderDTO dto);
    
}
