package com.kartik.wishlist.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */

@Document(collection = "wishlist")
public class WishlistItem {
    @Id
    private String id;

    private String userId;
    private Album album;

    private int duration_ms;

    private String trackId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String preview_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public WishlistItem(String id, Album album, int duration_ms, String trackId, String preview_url,String userId) {
        this.id = id;
        this.album = album;
        this.duration_ms = duration_ms;
        this.trackId = trackId;
        this.preview_url = preview_url;
        this.userId=userId;
    }

    public WishlistItem(){}
}
