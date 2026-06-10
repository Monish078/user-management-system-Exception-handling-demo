package com.ExceptionHandling_Demo.UserManagement.exception;

// ye sab throw karega jab user nhi melega
public class UserNotFoundException extends RuntimeException{

    // constructor jo hum message denge
    public UserNotFoundException (String message) {
        super(message);
    }

}
