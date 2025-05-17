package com.managmentbackend.task_management_system.advisor;

import com.managmentbackend.task_management_system.dto.request.AdminSaveDTO;
import com.managmentbackend.task_management_system.exception.EntryDuplicateException;
import com.managmentbackend.task_management_system.exception.NotFoundException;
import com.managmentbackend.task_management_system.exception.RuntimeErrorException;
import com.managmentbackend.task_management_system.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Not Found Error", e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EntryDuplicateException.class)
    public ResponseEntity<StandardResponse> handleDuplicateKeyException(EntryDuplicateException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(400, "Duplicate value error", e.getMessage()), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(RuntimeErrorException.class)
    public ResponseEntity<StandardResponse> handleRuntimeErrorException(RuntimeErrorException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Runtime Error!", e.getMessage()), HttpStatus.BAD_REQUEST
        );
    }
}
