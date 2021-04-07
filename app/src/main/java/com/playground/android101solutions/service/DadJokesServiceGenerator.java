package com.playground.android101solutions.service;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 07/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DadJokesServiceGenerator {

    private static final String BASE_URL = "https://icanhazdadjoke.com";

    private static final OkHttpClient.Builder httpClient
            = new OkHttpClient.Builder();

    private static final GsonBuilder gson
            = new GsonBuilder();

    private static final Retrofit.Builder builder
            = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(gson.create()));

    private static final Retrofit retrofit = builder.build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
