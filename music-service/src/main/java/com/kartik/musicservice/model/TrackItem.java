package com.kartik.musicservice.model;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */
public class TrackItem {

    private Album album;
    private int duration_ms;
    private String id;

    private String preview_url;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public TrackItem(Album album, int duration_ms, String id, String preview_url) {
        this.album = album;
        this.duration_ms = duration_ms;
        this.id = id;
        this.preview_url = preview_url;
    }

    public TrackItem(){}
}
