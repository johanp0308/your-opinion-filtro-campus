package com.campus.spring.youropinion.domain.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.campus.spring.youropinion.domain.excepciones.UserNotFoundException;
import com.campus.spring.youropinion.domain.repositories.GenderRepository;
import com.campus.spring.youropinion.domain.services.GenderService;
import com.campus.spring.youropinion.persistence.dto.GenderDTO;
import com.campus.spring.youropinion.persistence.entities.GenderEntity;


@Service
public class GenderServiceImpl implements GenderService{

    private final GenderRepository genderRepository;
    
    public GenderServiceImpl(GenderRepository gebGenderRepository){
        this.genderRepository = gebGenderRepository;
    }

    @Override
    public List<GenderDTO> getAllGender() {
        List<GenderEntity> lista = genderRepository.findAll();
        return (List<GenderDTO>) lista.stream().map(ele ->{
            GenderDTO dto = new GenderDTO();
            dto.toGenderDTO(ele);
            return dto;
        }).collect(Collectors.toList());

    }

    @Override
    public GenderDTO saveGender(GenderDTO dto) {
        try {
            
            GenderEntity goEntity = genderRepository.findById(dto.getId()).orElse(null);
        } catch (Exception e) {
            throw new Not
        }
        if(goEntity == null){

        }
    } 
    
}
