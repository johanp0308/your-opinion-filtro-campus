package com.campus.spring.youropinion.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tbl_content")
public class ContentEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_content")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;

    private String nameContent;
    private String statusContent;
    private int qualification;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_gender")
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "id_platform")
    private PlatformEntity platform;

    @ManyToOne
    @JoinColumn(name = "id_typeContent")
    private TypeContentEntity type;


    public ContentEntity() {
    }

    public ContentEntity(Long id, ProfileEntity profile, String nameContent, String statusContent, int qualification, String comment, GenderEntity gender, PlatformEntity platform, TypeContentEntity type) {
        this.id = id;
        this.profile = profile;
        this.nameContent = nameContent;
        this.statusContent = statusContent;
        this.qualification = qualification;
        this.comment = comment;
        this.gender = gender;
        this.platform = platform;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileEntity getProfile() {
        return this.profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public String getNameContent() {
        return this.nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public String getStatusContent() {
        return this.statusContent;
    }

    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }

    public int getQualification() {
        return this.qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GenderEntity getGender() {
        return this.gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public PlatformEntity getPlatform() {
        return this.platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public TypeContentEntity getType() {
        return this.type;
    }

    public void setType(TypeContentEntity type) {
        this.type = type;
    }

    public ContentEntity id(Long id) {
        setId(id);
        return this;
    }

    public ContentEntity profile(ProfileEntity profile) {
        setProfile(profile);
        return this;
    }

    public ContentEntity nameContent(String nameContent) {
        setNameContent(nameContent);
        return this;
    }

    public ContentEntity statusContent(String statusContent) {
        setStatusContent(statusContent);
        return this;
    }

    public ContentEntity qualification(int qualification) {
        setQualification(qualification);
        return this;
    }

    public ContentEntity comment(String comment) {
        setComment(comment);
        return this;
    }

    public ContentEntity gender(GenderEntity gender) {
        setGender(gender);
        return this;
    }

    public ContentEntity platform(PlatformEntity platform) {
        setPlatform(platform);
        return this;
    }

    public ContentEntity type(TypeContentEntity type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContentEntity)) {
            return false;
        }
        ContentEntity contentEntity = (ContentEntity) o;
        return Objects.equals(id, contentEntity.id) && Objects.equals(profile, contentEntity.profile) && Objects.equals(nameContent, contentEntity.nameContent) && Objects.equals(statusContent, contentEntity.statusContent) && qualification == contentEntity.qualification && Objects.equals(comment, contentEntity.comment) && Objects.equals(gender, contentEntity.gender) && Objects.equals(platform, contentEntity.platform) && Objects.equals(type, contentEntity.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profile, nameContent, statusContent, qualification, comment, gender, platform, type);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", profile='" + getProfile() + "'" +
            ", nameContent='" + getNameContent() + "'" +
            ", statusContent='" + getStatusContent() + "'" +
            ", qualification='" + getQualification() + "'" +
            ", comment='" + getComment() + "'" +
            ", gender='" + getGender() + "'" +
            ", platform='" + getPlatform() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

    
}
