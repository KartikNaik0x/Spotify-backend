package com.kartik.register.controller;

import com.kartik.register.model.User;
import com.kartik.register.response.ResponseHandler;
import com.kartik.register.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author {2095949}
 * @Date {29-11-2023}
 */
@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){
            return ResponseHandler.generateResponse("User registered successfully",HttpStatus.CREATED,userService.saveUser(user));

    }

}
