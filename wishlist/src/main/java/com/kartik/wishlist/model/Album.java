package com.kartik.wishlist.model;

import java.util.List;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */
public class Album {
    private List<Artist> artists;

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    private String name;

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

    public Album(List<Artist> artists, List<Image> images,String name, String release_date) {
        this.artists = artists;
        this.images=images;
        this.name = name;
        this.release_date = release_date;
    }

    public Album(){}
}
