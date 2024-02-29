package com.kartik.authentication.service;

import com.kartik.authentication.model.UserDto;
import com.kartik.authentication.repository.LoginRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@SpringBootTest
class LoginServiceImplTest {
    @Mock
    private LoginRepository loginRepository;
    @InjectMocks
    private LoginServiceImpl loginService;
    @Test
    void findByUsername_ValidUsername_ReturnsUserDto() {
        // Mocking the behavior of the repository
        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setUsername("testUser");
        expectedUserDto.setPassword("hashedPassword"); // You need to set an appropriate hashed password
        when(loginRepository.findByUsername("testUser")).thenReturn(Optional.of(expectedUserDto));
        // Calling the service method
        Optional<UserDto> actualUserDto = loginService.findByUsername("testUser");
        // Assertions
        assertEquals(expectedUserDto, actualUserDto.orElse(null));
    }
    @Test
    void findByUsername_InvalidUsername_ReturnsEmptyOptional() {
        // Mocking the behavior of the repository for an invalid username
        when(loginRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        // Calling the service method with an invalid username
        Optional<UserDto> actualUserDto = loginService.findByUsername("nonExistingUser");
        // Assertions
        assertEquals(Optional.empty(), actualUserDto);
    }
    // You can add more tests for other methods in the service as needed
}





