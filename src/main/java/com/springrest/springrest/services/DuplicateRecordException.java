package com.springrest.springrest.services;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message) {
        super("duplicate should not be their");
    }
}
