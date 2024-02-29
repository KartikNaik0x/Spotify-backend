package com.kartik.musicservice.model;

import java.util.List;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */
public class Tracks {

    private List<TrackItem> items;

    public List<TrackItem> getItems() {
        return items;
    }

    public void setItems(List<TrackItem> items) {
        this.items = items;
    }

    public Tracks(List<TrackItem> items) {
        this.items = items;
    }

    public Tracks(){}
}
