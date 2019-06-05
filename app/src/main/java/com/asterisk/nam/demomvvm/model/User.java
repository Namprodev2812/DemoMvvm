package com.asterisk.nam.demomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getFullName() {
        return fullName;
    }
}
