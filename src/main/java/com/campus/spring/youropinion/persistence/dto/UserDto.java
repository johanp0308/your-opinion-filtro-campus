package com.campus.spring.youropinion.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String email;
    private String token;


    public UserDto() {
    }

    public UserDto(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto email(String email) {
        setEmail(email);
        return this;
    }

    public UserDto token(String token) {
        setToken(token);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(email, userDto.email) && Objects.equals(token, userDto.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, token);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", token='" + getToken() + "'" +
            "}";
    }
    
}
