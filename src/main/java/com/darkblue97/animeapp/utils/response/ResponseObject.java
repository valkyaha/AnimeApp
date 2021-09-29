package com.darkblue97.animeapp.utils.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ResponseObject {

    private LocalDateTime timestamp;
    private Object objectResponse;
    private HttpStatus status;
    private String message;
    private String error;

    public ResponseObject(LocalDateTime timestamp, Object objectResponse, HttpStatus status, String message, String error) {
        this.timestamp = timestamp;
        this.objectResponse = objectResponse;
        this.status = status;
        this.message = message;
        this.error = error;
    }
}
