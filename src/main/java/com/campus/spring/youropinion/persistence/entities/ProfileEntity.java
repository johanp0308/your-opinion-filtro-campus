package com.campus.spring.youropinion.persistence.entities;


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

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_profile")
public class ProfileEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long id;

    private String nameProfile;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @OneToMany(mappedBy = "profile", cascade =  CascadeType.ALL, fetch =  FetchType.EAGER)
    private List<TypeContentEntity> typeContents;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GenderEntity> genders;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PlatformEntity> platforms;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ContentEntity> contents;


    public ProfileEntity() {
    }

    public ProfileEntity(Long id, String nameProfile, UserEntity user, List<TypeContentEntity> typeContents, List<GenderEntity> genders, List<PlatformEntity> platforms, List<ContentEntity> contents) {
        this.id = id;
        this.nameProfile = nameProfile;
        this.user = user;
        this.typeContents = typeContents;
        this.genders = genders;
        this.platforms = platforms;
        this.contents = contents;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProfile() {
        return this.nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TypeContentEntity> getTypeContents() {
        return this.typeContents;
    }

    public void setTypeContents(List<TypeContentEntity> typeContents) {
        this.typeContents = typeContents;
    }

    public List<GenderEntity> getGenders() {
        return this.genders;
    }

    public void setGenders(List<GenderEntity> genders) {
        this.genders = genders;
    }

    public List<PlatformEntity> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(List<PlatformEntity> platforms) {
        this.platforms = platforms;
    }

    public List<ContentEntity> getContents() {
        return this.contents;
    }

    public void setContents(List<ContentEntity> contents) {
        this.contents = contents;
    }

    public ProfileEntity id(Long id) {
        setId(id);
        return this;
    }

    public ProfileEntity nameProfile(String nameProfile) {
        setNameProfile(nameProfile);
        return this;
    }

    public ProfileEntity user(UserEntity user) {
        setUser(user);
        return this;
    }

    public ProfileEntity typeContents(List<TypeContentEntity> typeContents) {
        setTypeContents(typeContents);
        return this;
    }

    public ProfileEntity genders(List<GenderEntity> genders) {
        setGenders(genders);
        return this;
    }

    public ProfileEntity platforms(List<PlatformEntity> platforms) {
        setPlatforms(platforms);
        return this;
    }

    public ProfileEntity contents(List<ContentEntity> contents) {
        setContents(contents);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProfileEntity)) {
            return false;
        }
        ProfileEntity profileEntity = (ProfileEntity) o;
        return Objects.equals(id, profileEntity.id) && Objects.equals(nameProfile, profileEntity.nameProfile) && Objects.equals(user, profileEntity.user) && Objects.equals(typeContents, profileEntity.typeContents) && Objects.equals(genders, profileEntity.genders) && Objects.equals(platforms, profileEntity.platforms) && Objects.equals(contents, profileEntity.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProfile, user, typeContents, genders, platforms, contents);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nameProfile='" + getNameProfile() + "'" +
            ", user='" + getUser() + "'" +
            ", typeContents='" + getTypeContents() + "'" +
            ", genders='" + getGenders() + "'" +
            ", platforms='" + getPlatforms() + "'" +
            ", contents='" + getContents() + "'" +
            "}";
    }

}
