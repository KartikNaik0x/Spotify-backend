package com.kartik.authentication.controller;


import com.kartik.authentication.controller.LoginController;
import com.kartik.authentication.model.LoginRequest;
import com.kartik.authentication.model.UserDto;
import com.kartik.authentication.service.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.mockito.Mockito.when;
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LoginServiceImpl loginService;
    @Test
    void loginUser_ValidCredentials_ReturnsToken() throws Exception {
        // Mock the behavior of your service
        UserDto userDto = new UserDto();
        userDto.setUsername("testUser");
        userDto.setPassword(new BCryptPasswordEncoder().encode("password"));
        when(loginService.findByUsername("testUser")).thenReturn(Optional.of(userDto));
        when(loginService.generateToken(Mockito.any(LoginRequest.class))).thenReturn(getTestToken());
        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"testUser\", \"password\": \"password\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").exists());
    }

    @Test
    void loginUser_InvalidCredentials_ReturnsConflict() throws Exception {
        // Mock the behavior of your service for invalid credentials
        when(loginService.findByUsername("invalidUser")).thenReturn(Optional.empty());
        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"invalidUser\", \"password\": \"invalidPassword\" }"))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }
    private Map<String, String> getTestToken() {
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", "testToken");
        return tokenMap;
    }
}





