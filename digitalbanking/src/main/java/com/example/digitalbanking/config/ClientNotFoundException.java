package com.example.digitalbanking.config;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String errorBody) {
        super(errorBody);
    }
}
