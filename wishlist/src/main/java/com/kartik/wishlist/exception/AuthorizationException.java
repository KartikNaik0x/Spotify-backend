package com.kartik.wishlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author {2095949}
 * @Date {06-12-2023}
 */

@Component
public class AuthorizationException extends Exception{

    public ResponseEntity<?> throwAuthorizationException(String msg) {

        return new ResponseEntity<>("Access Denied", HttpStatus.FORBIDDEN);
    }
}
