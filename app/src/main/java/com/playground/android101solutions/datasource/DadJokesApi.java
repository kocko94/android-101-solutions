package com.playground.android101solutions.datasource;

import com.playground.android101solutions.model.DadJoke;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created on 01/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface DadJokesApi {

    @GET
    Call<DadJoke> getJoke();
}
