package com.asterisk.nam.demomvvm.retrofit;

import com.asterisk.nam.demomvvm.model.Genre;
import com.asterisk.nam.demomvvm.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataClient {

    @GET("charts?kind=" + Constants.KIND_TREND)
    Observable<Genre> register(
            @Query(Constants.URL_GENRE) String genre,
            @Query(Constants.URL_CLIENT_ID) String client_id,
            @Query(Constants.URL_LIMIT) int limit,
            @Query(Constants.URL_OFFSET) int offset);
}
