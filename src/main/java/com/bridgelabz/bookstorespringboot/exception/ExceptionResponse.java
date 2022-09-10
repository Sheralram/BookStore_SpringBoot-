package com.bridgelabz.bookstorespringboot.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ExceptionResponse {
    String message;
    HttpStatus status;
    Object data;
    String statusMsg;

    public ExceptionResponse(String message, Object user, HttpStatus status, String statusMsg) {
        this.message = message;
        this.data = user;
        this.status = status;
        this.statusMsg = statusMsg;
    }
}