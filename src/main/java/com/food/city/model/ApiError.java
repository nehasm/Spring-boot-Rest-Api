package com.food.city.model;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> details;
    private LocalDateTime timestamp;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ApiError(HttpStatus status, String message, List<String> details, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }
}
