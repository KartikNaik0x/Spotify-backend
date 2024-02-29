package com.kartik.musicservice.model;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */
public class ApiResponse {
    private Tracks tracks;

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public ApiResponse(Tracks tracks) {
        this.tracks = tracks;
    }
    public ApiResponse(){}
}
