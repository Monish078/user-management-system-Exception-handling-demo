package com.ExceptionHandling_Demo.UserManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// ye response client ko bhejna hota hai
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {  //ye response dto hai jo client ko error pe bhejte hai
    private int status;

    private String message;


    private LocalDateTime localDateTime;


}
