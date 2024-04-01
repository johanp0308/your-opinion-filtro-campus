package com.campus.spring.youropinion.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.spring.youropinion.persistence.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity,Long>{
    
}
