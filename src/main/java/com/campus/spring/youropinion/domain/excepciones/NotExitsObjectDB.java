package com.campus.spring.youropinion.domain.excepciones;

public class NotExitsObjectDB extends RuntimeException{
    public NotExitsObjectDB(String message){
        super(message);
    }
}
