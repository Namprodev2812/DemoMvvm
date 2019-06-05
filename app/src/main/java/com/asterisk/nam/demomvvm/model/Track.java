package com.asterisk.nam.demomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("artwork_url")
    @Expose
    private String mArtworkUrl;
    @SerializedName("id")
    @Expose
    private Integer mId;
    @SerializedName("user")
    @Expose
    private User mUser;

    public String getTitle() {
        return mTitle;
    }

    public User getUser() {
        return mUser;
    }
}
