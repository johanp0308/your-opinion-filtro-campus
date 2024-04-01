package com.campus.spring.youropinion.persistence.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tbl_platform")
public class PlatformEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_platform")
    private Long id;

    private String namePlatform;
    
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ContentEntity> contents;


    public PlatformEntity() {
    }

    public PlatformEntity(Long id, String namePlatform, ProfileEntity profile, List<ContentEntity> contents) {
        this.id = id;
        this.namePlatform = namePlatform;
        this.profile = profile;
        this.contents = contents;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePlatform() {
        return this.namePlatform;
    }

    public void setNamePlatform(String namePlatform) {
        this.namePlatform = namePlatform;
    }

    public ProfileEntity getProfile() {
        return this.profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public List<ContentEntity> getContents() {
        return this.contents;
    }

    public void setContents(List<ContentEntity> contents) {
        this.contents = contents;
    }

    public PlatformEntity id(Long id) {
        setId(id);
        return this;
    }

    public PlatformEntity namePlatform(String namePlatform) {
        setNamePlatform(namePlatform);
        return this;
    }

    public PlatformEntity profile(ProfileEntity profile) {
        setProfile(profile);
        return this;
    }

    public PlatformEntity contents(List<ContentEntity> contents) {
        setContents(contents);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PlatformEntity)) {
            return false;
        }
        PlatformEntity platformEntity = (PlatformEntity) o;
        return Objects.equals(id, platformEntity.id) && Objects.equals(namePlatform, platformEntity.namePlatform) && Objects.equals(profile, platformEntity.profile) && Objects.equals(contents, platformEntity.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namePlatform, profile, contents);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", namePlatform='" + getNamePlatform() + "'" +
            ", profile='" + getProfile() + "'" +
            ", contents='" + getContents() + "'" +
            "}";
    }
    
}
