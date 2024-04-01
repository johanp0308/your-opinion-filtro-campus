package com.campus.spring.youropinion.persistence.dto;

import com.campus.spring.youropinion.persistence.entities.GenderEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenderDTO {
    
    private Long id;
    private String nameGender;
    private Long idprofile;


    public GenderDTO() {
    }

    public GenderDTO(Long id, String nameGender, Long idprofile) {
        this.id = id;
        this.nameGender = nameGender;
        this.idprofile = idprofile;
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

    public Long getIdprofile() {
        return this.idprofile;
    }

    public void setIdprofile(Long idprofile) {
        this.idprofile = idprofile;
    }

    public GenderDTO id(Long id) {
        setId(id);
        return this;
    }

    public GenderDTO nameGender(String nameGender) {
        setNameGender(nameGender);
        return this;
    }

    public GenderDTO idprofile(Long idprofile) {
        setIdprofile(idprofile);
        return this;
    }

    public GenderDTO toGenderDTO(GenderEntity genderEntity){
        GenderDTO dto = new GenderDTO();
        dto.setId(genderEntity.getId());
        dto.setIdprofile(genderEntity.getProfile().getId());
        dto.setNameGender(genderEntity.getNameGender());
        return dto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GenderDTO)) {
            return false;
        }
        GenderDTO genderDTO = (GenderDTO) o;
        return Objects.equals(id, genderDTO.id) && Objects.equals(nameGender, genderDTO.nameGender) && Objects.equals(idprofile, genderDTO.idprofile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameGender, idprofile);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nameGender='" + getNameGender() + "'" +
            ", idprofile='" + getIdprofile() + "'" +
            "}";
    }
    
}
