package com.kartik.register.service;

import com.kartik.register.dto.UserDto;
import com.kartik.register.model.User;
import com.kartik.register.repository.UserRepository;
import com.kartik.register.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private KafkaTemplate<String, UserDto> template;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser_Success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setMobileNumber("1234567890");
        user.setPassword("password");

        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userRepository.findByMobileNumber(anyString())).thenReturn(null);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        UserDto result = userService.saveUser(user);

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertEquals("encodedPassword", result.getPassword());

        verify(template).send(eq("test-topic"), any(UserDto.class));
        verify(userRepository).save(any(User.class));
    }

    @Test
    void saveUser_DuplicateEmail() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findByEmail(anyString())).thenReturn(new User());

        assertThrows(DataIntegrityViolationException.class, () -> userService.saveUser(user));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void saveUser_DuplicateUsername() {
        User user = new User();
        user.setUsername("testuser");

        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userRepository.findByUsername(anyString())).thenReturn(new User());

        assertThrows(DataIntegrityViolationException.class, () -> userService.saveUser(user));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void saveUser_DuplicateMobileNumber() {
        User user = new User();
        user.setMobileNumber("1234567890");

        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userRepository.findByMobileNumber(anyString())).thenReturn(new User());

        assertThrows(DataIntegrityViolationException.class, () -> userService.saveUser(user));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void findByUsername() {
        when(userRepository.findByUsername(eq("testuser"))).thenReturn(new User());

        User result = userService.findByUsername("testuser");

        assertNotNull(result);
        verify(userRepository).findByUsername(eq("testuser"));
    }
}