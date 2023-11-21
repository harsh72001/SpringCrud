package com.springrest.springrest.services;



public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("their is no course of this name ");
    }
}

