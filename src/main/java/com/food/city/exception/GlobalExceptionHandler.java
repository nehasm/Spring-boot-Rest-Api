package com.food.city.exception;

import com.food.city.model.ApiError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public GlobalExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Request Method not Supported");
        ApiError  error = new ApiError(
                status,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Media type not Supported");
        ApiError  error = new ApiError(
                status,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Path Variable is missing");
        ApiError  error = new ApiError(
                status,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Mismatch of type");
        ApiError  error = new ApiError(
                status,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Request body is not readable");
        ApiError  error = new ApiError(
                status,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Object> handleRestaurantNotException(RestaurantNotFoundException ex){
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Restaurants not found");
        ApiError  error = new ApiError(
                HttpStatus.BAD_REQUEST,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception ex){
        String message = ex.getMessage();
        List<String> errors = new ArrayList<>();
        errors.add("Exception Occured");
        errors.add((ex.getMessage()));
        ApiError  error = new ApiError(
                HttpStatus.BAD_REQUEST,
                message,
                errors,
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
