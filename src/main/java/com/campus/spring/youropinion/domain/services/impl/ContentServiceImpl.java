package com.campus.spring.youropinion.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.campus.spring.youropinion.domain.repositories.ContentRepository;
import com.campus.spring.youropinion.domain.repositories.GenderRepository;
import com.campus.spring.youropinion.domain.repositories.PlatformRepository;
import com.campus.spring.youropinion.domain.repositories.ProfileRepository;
import com.campus.spring.youropinion.domain.repositories.TypeContentRepository;
import com.campus.spring.youropinion.domain.services.ContentService;
import com.campus.spring.youropinion.persistence.dto.ContentDTO;
import com.campus.spring.youropinion.persistence.entities.ContentEntity;


@Service
public class ContentServiceImpl implements ContentService{


    private final GenderRepository genderRepository;
    private final ProfileRepository profileRepository;
    private final PlatformRepository platformRepository;
    private final TypeContentRepository typeContentRepository;
    private final ContentRepository contentRepository;

    @Autowired
    public ContentServiceImpl(
            GenderRepository genderRepository,
            ProfileRepository profileRepository,
            PlatformRepository platformRepository,
            TypeContentRepository typeContentRepository,
            ContentRepository contentRepository){
        this.genderRepository = genderRepository;
        this.profileRepository = profileRepository;
        this.platformRepository = platformRepository;
        this.typeContentRepository = typeContentRepository;
        this.contentRepository = contentRepository;
    }



    @Override
    public ResponseEntity<Object> saveContent(ContentDTO cDto) {
        
        if(cDto.getStatusContent().equalsIgnoreCase("Terminado") || cDto.getStatusContent().equalsIgnoreCase("Abandonado")){
            ContentEntity contentEntity = new ContentEntity();
            contentEntity.setId(cDto.getId());
            contentEntity.setNameContent(cDto.getNameContent());
            contentEntity.setProfile(profileRepository.findById(cDto.getIdProfile() | 0).orElse(null));
            contentEntity.setGender(genderRepository.findById(cDto.getIdGender() | 0).orElse(null));
            contentEntity.setPlatform(platformRepository.findById(cDto.getIdPlatform() | 0).orElse(null));
            contentEntity.setType(typeContentRepository.findById(cDto.getIdType() | 0).get());
            contentEntity.setQualification(cDto.getQualification());
            contentEntity.setComment(cDto.getComment());
            contentEntity.setStatusContent(cDto.getStatusContent());

            return ResponseEntity.ok().body(contentRepository.save(contentEntity));
        }else{
            ContentEntity contentEntity = new ContentEntity();
            contentEntity.setId(cDto.getId());
            contentEntity.setNameContent(cDto.getNameContent());
            contentEntity.setProfile(profileRepository.findById(cDto.getIdProfile() | 0).orElse(null));
            contentEntity.setGender(genderRepository.findById(cDto.getIdGender() | 0).orElse(null));
            contentEntity.setPlatform(platformRepository.findById(cDto.getIdPlatform() | 0).orElse(null));
            contentEntity.setType(typeContentRepository.findById(cDto.getIdType() | 0).get());
            contentEntity.setStatusContent(cDto.getStatusContent());

            return ResponseEntity.ok().body(contentRepository.save(contentEntity));
        }

    }
    
}
