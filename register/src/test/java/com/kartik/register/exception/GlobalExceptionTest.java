package com.kartik.register.exception;

import com.kartik.register.exception.GlobalException;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GlobalExceptionTest {

    private final GlobalException globalException = new GlobalException();

    @Test
    void handleDataIntegrityViolation() {
        // Mock DataIntegrityViolationException
        DataIntegrityViolationException exception = mock(DataIntegrityViolationException.class);

        // Call the method
        ResponseEntity<String> responseEntity = globalException.handleDataIntegrityViolation(exception);

        // Verify the response
        assertEquals("Bad Request",
                HttpStatus.valueOf(responseEntity.getStatusCodeValue()).getReasonPhrase());



    }
}
