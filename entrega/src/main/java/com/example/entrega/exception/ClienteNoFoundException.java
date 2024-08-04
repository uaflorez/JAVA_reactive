package com.example.entrega.exception;

public class ClienteNoFoundException extends RuntimeException {
    public ClienteNoFoundException(String message) {
        super(message);
    }
}
