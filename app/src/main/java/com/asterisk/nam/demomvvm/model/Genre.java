package com.asterisk.nam.demomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Genre {

    @SerializedName("collection")
    @Expose
    private List<Collection> collections;

    public List<Collection> getCollection() {
        return collections;
    }
}
