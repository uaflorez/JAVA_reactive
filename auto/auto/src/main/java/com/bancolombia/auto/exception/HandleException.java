package com.bancolombia.auto.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class HandleException {


    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<String> handleMyHandleException(MyHandleException ex) {
        return new ResponseEntity<>(
                "Error negocio: " + ex.getMessage(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String errorMessage = error.getField() + " : " + error.getDefaultMessage();
            errors.add(errorMessage);
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
