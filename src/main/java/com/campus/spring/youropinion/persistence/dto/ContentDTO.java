package com.campus.spring.youropinion.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentDTO {
    
    private Long id;
    private Long idProfile;

    private String nameContent;
    private String statusContent;
    private int qualification;
    private String comment;
    
    private Long idGender;
    private Long idPlatform;
    private Long idType;


    public ContentDTO() {
    }

    public ContentDTO(Long id, Long idProfile, String nameContent, String statusContent, int qualification, String comment, Long idGender, Long idPlatform, Long idType) {
        this.id = id;
        this.idProfile = idProfile;
        this.nameContent = nameContent;
        this.statusContent = statusContent;
        this.qualification = qualification;
        this.comment = comment;
        this.idGender = idGender;
        this.idPlatform = idPlatform;
        this.idType = idType;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProfile() {
        return this.idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
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

    public Long getIdGender() {
        return this.idGender;
    }

    public void setIdGender(Long idGender) {
        this.idGender = idGender;
    }

    public Long getIdPlatform() {
        return this.idPlatform;
    }

    public void setIdPlatform(Long idPlatform) {
        this.idPlatform = idPlatform;
    }

    public Long getIdType() {
        return this.idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public ContentDTO id(Long id) {
        setId(id);
        return this;
    }

    public ContentDTO idProfile(Long idProfile) {
        setIdProfile(idProfile);
        return this;
    }

    public ContentDTO nameContent(String nameContent) {
        setNameContent(nameContent);
        return this;
    }

    public ContentDTO statusContent(String statusContent) {
        setStatusContent(statusContent);
        return this;
    }

    public ContentDTO qualification(int qualification) {
        setQualification(qualification);
        return this;
    }

    public ContentDTO comment(String comment) {
        setComment(comment);
        return this;
    }

    public ContentDTO idGender(Long idGender) {
        setIdGender(idGender);
        return this;
    }

    public ContentDTO idPlatform(Long idPlatform) {
        setIdPlatform(idPlatform);
        return this;
    }

    public ContentDTO idType(Long idType) {
        setIdType(idType);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContentDTO)) {
            return false;
        }
        ContentDTO contentDTO = (ContentDTO) o;
        return Objects.equals(id, contentDTO.id) && Objects.equals(idProfile, contentDTO.idProfile) && Objects.equals(nameContent, contentDTO.nameContent) && Objects.equals(statusContent, contentDTO.statusContent) && qualification == contentDTO.qualification && Objects.equals(comment, contentDTO.comment) && Objects.equals(idGender, contentDTO.idGender) && Objects.equals(idPlatform, contentDTO.idPlatform) && Objects.equals(idType, contentDTO.idType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProfile, nameContent, statusContent, qualification, comment, idGender, idPlatform, idType);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idProfile='" + getIdProfile() + "'" +
            ", nameContent='" + getNameContent() + "'" +
            ", statusContent='" + getStatusContent() + "'" +
            ", qualification='" + getQualification() + "'" +
            ", comment='" + getComment() + "'" +
            ", idGender='" + getIdGender() + "'" +
            ", idPlatform='" + getIdPlatform() + "'" +
            ", idType='" + getIdType() + "'" +
            "}";
    }
    

}
