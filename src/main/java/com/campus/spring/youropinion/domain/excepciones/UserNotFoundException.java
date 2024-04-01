package com.campus.spring.youropinion.domain.excepciones;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    } 
}
