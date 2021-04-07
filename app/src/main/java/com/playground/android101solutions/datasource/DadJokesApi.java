package com.playground.android101solutions.datasource;

import com.playground.android101solutions.model.DadJoke;
import com.playground.android101solutions.model.FatDadJoke;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created on 01/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface DadJokesApi {

    @Headers({"Accept: application/json"})
    @GET("/")
    Call<DadJoke> getJoke();

    @Headers({"Accept: application/json"})
    @GET("/search")
    Call<FatDadJoke> getJokesFor(@Query("term") String term);
}
