package com.project.AirBNB.AirBNB.security.exception;

public class UnAuthorisedException extends RuntimeException{
    public UnAuthorisedException(String message) {
        super(message);
    }
}
