package com.ExceptionHandling_Demo.UserManagement.exception;


import com.ExceptionHandling_Demo.UserManagement.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@RestControllerAdvice  // ye poori application ke liye , sare exception handle kata
public class GlobalExceptionHandler {

    // User not found exception yaha handle kardo  -> ese hi hita hai koi sa bhi
    @ExceptionHandler(UserNotFoundException.class)  // -> ye Notation jarooi hai
    public ResponseEntity<ErrorResponse> userNotFound(UserNotFoundException ex)  {
        // create akro response object ko                                                       tim me creation ke time dedo
        ErrorResponse response = new ErrorResponse(404,ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // EmailAlreadyExistsException ko handle karne ke liye bhi same  // isme exc do
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> emailAlreadyExists(EmailAlreadyExistsException ex) {
        // error response object banayo
        ErrorResponse errorResponse = new ErrorResponse(409,ex.getMessage(),LocalDateTime.now()); //

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

}
