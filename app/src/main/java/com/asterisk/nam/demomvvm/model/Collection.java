package com.asterisk.nam.demomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("track")
    @Expose
    Track track;

    public Track getTrack() {
        return track;
    }

}
