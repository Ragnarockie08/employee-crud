package com.example.crud.exception;

public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
