package com.kartik.musicservice.controller;

import com.kartik.musicservice.exception.AuthorizationException;
import com.kartik.musicservice.feign.AuthClient;
import com.kartik.musicservice.model.ApiResponse;
import com.kartik.musicservice.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/spotify")
public class SpotifyController {

    private final SpotifyService spotifyService;

    @Autowired
    AuthClient client;

    @Autowired
    AuthorizationException exp;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/search/{query}")
    public ResponseEntity<?> searchTracks(@PathVariable String query) {

                ApiResponse apiResponse = spotifyService.searchTracks(query);
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);


    }
}
