package com.campus.spring.youropinion.persistence.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name =  "tbl_gender_content")
public class GenderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Long id;

    private String nameGender;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;

    @OneToMany(mappedBy = "gender")
    private List<ContentEntity> contents;


    public GenderEntity() {
    }

    public GenderEntity(Long id, String nameGender, ProfileEntity profile, List<ContentEntity> contents) {
        this.id = id;
        this.nameGender = nameGender;
        this.profile = profile;
        this.contents = contents;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGender() {
        return this.nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
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

    public GenderEntity id(Long id) {
        setId(id);
        return this;
    }

    public GenderEntity nameGender(String nameGender) {
        setNameGender(nameGender);
        return this;
    }

    public GenderEntity profile(ProfileEntity profile) {
        setProfile(profile);
        return this;
    }

    public GenderEntity contents(List<ContentEntity> contents) {
        setContents(contents);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GenderEntity)) {
            return false;
        }
        GenderEntity genderEntity = (GenderEntity) o;
        return Objects.equals(id, genderEntity.id) && Objects.equals(nameGender, genderEntity.nameGender) && Objects.equals(profile, genderEntity.profile) && Objects.equals(contents, genderEntity.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameGender, profile, contents);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nameGender='" + getNameGender() + "'" +
            ", profile='" + getProfile() + "'" +
            ", contents='" + getContents() + "'" +
            "}";
    }
    
}
