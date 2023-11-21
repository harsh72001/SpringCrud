package com.springrest.springrest.services;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}