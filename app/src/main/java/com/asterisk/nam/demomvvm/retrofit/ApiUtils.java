package com.asterisk.nam.demomvvm.retrofit;

public class ApiUtils {

    public static final String BASE_URL = "https://api-v2.soundcloud.com/";
    public static final int REQUEST_TIME = 3000;
    public static final int CONNECT_TIME_OUT = 10000;

    public static DataClient getData() {
        return RetrofitClient.getClient(BASE_URL).create(DataClient.class);
    }
}
