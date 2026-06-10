package com.ExceptionHandling_Demo.UserManagement.exception;

// ek aur exception -. EmailAlreadyExistsException , hab email same h
public class EmailAlreadyExistsException extends RuntimeException{

                                        // ye jo message dete hai service ke metho me
    public  EmailAlreadyExistsException(String message) {
        super(message);
    }
}
