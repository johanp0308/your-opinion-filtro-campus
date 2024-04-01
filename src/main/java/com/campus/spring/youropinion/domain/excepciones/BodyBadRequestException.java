package com.campus.spring.youropinion.domain.excepciones;

public class BodyBadRequestException extends RuntimeException{
    public BodyBadRequestException(String message){
        super(message);
    }
}
