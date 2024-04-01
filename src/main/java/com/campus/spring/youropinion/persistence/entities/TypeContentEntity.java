package com.campus.spring.youropinion.persistence.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "tbl_type_content")
public class TypeContentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameContent;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;

    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ContentEntity> contents;

    public TypeContentEntity() {
    }

    public TypeContentEntity(Long id, String nameContent, ProfileEntity profile, List<ContentEntity> contents) {
        this.id = id;
        this.nameContent = nameContent;
        this.profile = profile;
        this.contents = contents;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameContent() {
        return this.nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
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

    public TypeContentEntity id(Long id) {
        setId(id);
        return this;
    }

    public TypeContentEntity nameContent(String nameContent) {
        setNameContent(nameContent);
        return this;
    }

    public TypeContentEntity profile(ProfileEntity profile) {
        setProfile(profile);
        return this;
    }

    public TypeContentEntity contents(List<ContentEntity> contents) {
        setContents(contents);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TypeContentEntity)) {
            return false;
        }
        TypeContentEntity typeContentEntity = (TypeContentEntity) o;
        return Objects.equals(id, typeContentEntity.id) && Objects.equals(nameContent, typeContentEntity.nameContent) && Objects.equals(profile, typeContentEntity.profile) && Objects.equals(contents, typeContentEntity.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameContent, profile, contents);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nameContent='" + getNameContent() + "'" +
            ", profile='" + getProfile() + "'" +
            ", contents='" + getContents() + "'" +
            "}";
    }

    
}
