package com.kartik.authentication.controller;

import com.kartik.authentication.model.LoginRequest;
import com.kartik.authentication.model.UserDto;
import com.kartik.authentication.model.LoginResponse;
import com.kartik.authentication.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @author {2095949}
 * @Date {02-12-2023}
 */

@RestController
@RequestMapping("/auth")
//@CrossOrigin("http://localhost:4200")
public class LoginController {

    private final LoginServiceImpl loginService;
    @Autowired
    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest userCredentials) throws Exception {
        //System.out.println(loginService.findByUsername(userCredentials.getUsername()));
        try {
            if (userCredentials.getUsername() == null || userCredentials.getPassword() == null) {
                throw new Exception("username and password cannot be null");
            }
            Optional<UserDto> login = loginService.findByUsername(userCredentials.getUsername());
            BCryptPasswordEncoder decode = new BCryptPasswordEncoder();
            if (!(decode.matches(userCredentials.getPassword(), login.get().getPassword()))) {
                throw new Exception("Invalid Password");
            }
            Map<String, String> token = loginService.generateToken(userCredentials);
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/validateToken")
    public boolean validateUser(@RequestHeader("Authorization") String token) {
        String authToken = token.substring(7,token.length());
//        System.out.println("tokennn without modification"+ token);
//        System.out.println("tokennn"+ authToken);
//        System.out.println(loginService.extractUsername(token.substring(7)));
        return loginService.validateToken(authToken);
    }

    @GetMapping("/getUsername")
    public String getUsername(@RequestHeader("Authorization") String token) {
        return loginService.extractUsername(token.substring(7));
    }
}
