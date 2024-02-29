package com.kartik.register.response;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author {2095949}
 * @Date {30-11-2023}
 */
public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatusCode status, Object responseObject){
        Map<String, Object> response = new HashMap<>();
        response.put("message",message);
        response.put("httpStatus",status);
        response.put("Object",responseObject);
        return new ResponseEntity<>(response,status);
    }
}
