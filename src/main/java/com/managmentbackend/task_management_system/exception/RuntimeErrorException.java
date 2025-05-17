package com.managmentbackend.task_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RuntimeErrorException extends RuntimeException{
    public RuntimeErrorException(String message){
        super(message);
    }
}
