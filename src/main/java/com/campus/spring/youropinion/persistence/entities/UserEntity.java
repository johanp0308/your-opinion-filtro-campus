package com.campus.spring.youropinion.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tbl_user")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    private String emailUser;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProfileEntity> profiles;
    

    public UserEntity() {
    }

    public UserEntity(Long id, String emailUser, String password, List<ProfileEntity> profiles) {
        this.id = id;
        this.emailUser = emailUser;
        this.password = password;
        this.profiles = profiles;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailUser() {
        return this.emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProfileEntity> getProfiles() {
        return this.profiles;
    }

    public void setProfiles(List<ProfileEntity> profiles) {
        this.profiles = profiles;
    }

    public UserEntity id(Long id) {
        setId(id);
        return this;
    }

    public UserEntity emailUser(String emailUser) {
        setEmailUser(emailUser);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity profiles(List<ProfileEntity> profiles) {
        setProfiles(profiles);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(emailUser, userEntity.emailUser) && Objects.equals(password, userEntity.password) && Objects.equals(profiles, userEntity.profiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emailUser, password, profiles);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", emailUser='" + getEmailUser() + "'" +
            ", password='" + getPassword() + "'" +
            ", profiles='" + getProfiles() + "'" +
            "}";
    }

}
