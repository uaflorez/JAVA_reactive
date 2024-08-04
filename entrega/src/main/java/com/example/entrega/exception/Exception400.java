package com.example.entrega.exception;

public class Exception400 extends RuntimeException{
    public Exception400(String errorBody) {
        super(errorBody);
    }
}
