package com.campus.spring.youropinion.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.spring.youropinion.persistence.entities.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity,Long>{
    
}
