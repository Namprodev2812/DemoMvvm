package com.asterisk.nam.demomvvm.retrofit;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(ApiUtils.REQUEST_TIME, TimeUnit.MILLISECONDS);
        builder.writeTimeout(ApiUtils.REQUEST_TIME, TimeUnit.MILLISECONDS);
        builder.connectTimeout(ApiUtils.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(true);

        GsonBuilder gsonBuilder = new GsonBuilder();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(builder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gsonBuilder.setLenient().create()))
                    .build();
        }
        return retrofit;
    }
}
