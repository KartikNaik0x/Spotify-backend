package com.kartik.register.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author {2095949}
 * @Date {29-11-2023}
 */

@ControllerAdvice
public class GlobalException {



    @ExceptionHandler
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException e){
        System.out.println(e.getRootCause());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
