package com.etiya.fullstack.core.utils.exceptions.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}