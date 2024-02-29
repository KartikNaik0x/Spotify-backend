package com.kartik.musicservice.service;

import com.kartik.musicservice.model.AccessTokenResponse;
import com.kartik.musicservice.model.ApiResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Base64;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */

@Service
public class SpotifyService {

    private final String SPOTIFY_API_URL = "https://api.spotify.com/v1/search?q=%s&type=track&limit=30";
    private final String CLIENT_ID = "abf2ff1dd8cf44be81ec215651343008";
    private final String CLIENT_SECRET = "8c32aef472864c9eb2a28c5a6134aa02";
    private final String TOKEN_ENDPOINT = "https://accounts.spotify.com/api/token";

    private Instant tokenExpiration;

    private final String BEARER_TOKEN="BQCjC1vZpMckKSPitWJvKB5Fgs6O9Px-UmzM5auFpBauNGsIg07h8mady_PrxOtLN8meh8MV3gOMtQ1DrO9BpyhRKD-CwYKE1U7gygbwWUANPFSiS18";

    private String bearerToken;
    private final RestTemplate restTemplate;

    public SpotifyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.bearerToken = generateAccessToken();
        this.tokenExpiration = Instant.now().plusSeconds(3600);
    }

    private String generateAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String base64Credentials = new String(Base64.getEncoder().encode(credentials.getBytes()));
        headers.add("Authorization", "Basic " + base64Credentials);
        System.out.println("crede"+base64Credentials);
        HttpEntity<String> request = new HttpEntity<>("grant_type=client_credentials", headers);
        ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.postForEntity(TOKEN_ENDPOINT, request, AccessTokenResponse.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("token generated");
            return responseEntity.getBody().getAccess_token();
        } else {
            throw new RuntimeException("Error in obtaining Spotify access token. HTTP Status: " + responseEntity.getStatusCode());
        }
    }

    public ApiResponse searchTracks(String queryString){
        if (Instant.now().isAfter(tokenExpiration)) {
            // Token has expired, generate a new one
            this.bearerToken = generateAccessToken();
            this.tokenExpiration = Instant.now().plusSeconds(3600); // Update the expiration time
        }

        String apiUrl = String.format(SPOTIFY_API_URL,queryString);
        System.out.println(apiUrl);
        HttpHeaders headers= new HttpHeaders();

        headers.add("Authorization","Bearer "+bearerToken);

        ResponseEntity<ApiResponse> responseEntity= restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                ApiResponse.class
        );

        if(responseEntity.getStatusCode()== HttpStatus.OK){
            return responseEntity.getBody();
        }
        else{
            throw new RuntimeException("Error in Spotify Api"+ responseEntity.getStatusCode());

        }

    }
}
