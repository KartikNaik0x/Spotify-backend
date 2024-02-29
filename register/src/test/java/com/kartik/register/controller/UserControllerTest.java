package com.kartik.register.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartik.register.controller.UserController;
import com.kartik.register.model.User;
import com.kartik.register.response.ResponseHandler;
import com.kartik.register.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_Success() {
        // Create a sample user
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        // Mock the service response
       // when(userService.saveUser(any(User.class))).thenReturn(user);

        // Call the controller method
        ResponseEntity<Object> responseEntity = userController.registerUser(user);

        // Verify the response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        //dont comment below lines
//        assertEquals("User registered successfully", ResponseHandler.getMessage(responseEntity));
//        assertEquals(user, ResponseHandler.getData(responseEntity));

        // Verify that the service method was called with the correct user
        verify(userService).saveUser(eq(user));
    }



}