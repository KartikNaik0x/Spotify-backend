package com.kartik.musicservice.model;

import java.util.List;

/**
 * @author {2095949}
 * @Date {04-12-2023}
 */
public class Album {
    private List<Artist> artists;

    private List<Image> images;
    private String name;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    private String release_date;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Album(List<Artist> artists, String name, String release_date , List<Image> images) {
        this.artists = artists;
        this.name = name;
        this.release_date = release_date;
        this.images = images;
    }

    public Album(){}
}
