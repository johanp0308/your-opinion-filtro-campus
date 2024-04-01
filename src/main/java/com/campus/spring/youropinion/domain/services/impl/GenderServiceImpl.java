package com.campus.spring.youropinion.domain.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.campus.spring.youropinion.domain.excepciones.BodyBadRequestException;
import com.campus.spring.youropinion.domain.excepciones.NotExitsObjectDB;
import com.campus.spring.youropinion.domain.excepciones.UserNotFoundException;
import com.campus.spring.youropinion.domain.repositories.GenderRepository;
import com.campus.spring.youropinion.domain.repositories.ProfileRepository;
import com.campus.spring.youropinion.domain.services.GenderService;
import com.campus.spring.youropinion.persistence.dto.GenderDTO;
import com.campus.spring.youropinion.persistence.entities.GenderEntity;


@Service
public class GenderServiceImpl implements GenderService{

    private final GenderRepository genderRepository;
    private final ProfileRepository profileRepository;
    
    public GenderServiceImpl(
            GenderRepository gebGenderRepository,
            ProfileRepository profileRepository){
        this.genderRepository = gebGenderRepository;
        this.profileRepository = profileRepository;
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
            
            GenderEntity genderEntity = new GenderEntity();
            genderEntity.setNameGender(dto.getNameGender());
            genderEntity.setProfile(profileRepository.findById(dto.getIdprofile()).orElse(null));

            GenderEntity response = genderRepository.save(genderEntity);
            GenderDTO responseDt = GenderDTO.toGenderDTO(response);
            return responseDt;
            
        } catch (Exception e) {
            throw new BodyBadRequestException("Incorrect parameters in the body: "+e.getMessage());
        }
    } 
    
}
