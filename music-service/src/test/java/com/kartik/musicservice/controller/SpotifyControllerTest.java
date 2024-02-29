package com.kartik.musicservice.controller;

import com.kartik.musicservice.controller.SpotifyController;
import com.kartik.musicservice.model.ApiResponse;
import com.kartik.musicservice.service.SpotifyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpotifyControllerTest {

    @Mock
    private SpotifyService spotifyService;

    @InjectMocks
    private SpotifyController spotifyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void searchTracks_Success() {
//        // Mocking successful service response
//        ApiResponse expectedApiResponse = new ApiResponse(/* Mock your response here */);
//        when(spotifyService.searchTracks(anyString())).thenReturn(expectedApiResponse);
//
//        // Calling the controller method
//        ResponseEntity<ApiResponse> responseEntity = spotifyController.searchTracks("query");
//
//        // Verifying the result
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(expectedApiResponse, responseEntity.getBody());
//
//        // Verifying that spotifyService.searchTracks was called with the correct argument
//        verify(spotifyService).searchTracks("query");
//    }

//    @Test
//    void searchTracks_Failure() {
//        // Mocking a failed service response
//        when(spotifyService.searchTracks(anyString())).thenThrow(new RuntimeException("Service error"));
//
//        // Calling the controller method
//        ResponseEntity<ApiResponse> responseEntity = spotifyController.searchTracks("query");
//
//        // Verifying the result for error response
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        assertEquals(null, responseEntity.getBody());  // Assuming the body is not set in case of an error
//
//        // Verifying that spotifyService.searchTracks was called with the correct argument
//        verify(spotifyService).searchTracks("query");
//    }
}