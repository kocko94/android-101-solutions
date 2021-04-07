package com.playground.android101solutions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.playground.android101solutions.datasource.DadJokesApi;
import com.playground.android101solutions.model.DadJoke;
import com.playground.android101solutions.model.FatDadJoke;
import com.playground.android101solutions.service.DadJokesServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseTextView = findViewById(R.id.text);
        findViewById(R.id.btn_request).setOnClickListener(view -> requestJokeFor("cat"));
//        findViewById(R.id.btn_request).setOnClickListener(view -> requestJoke());
    }

    private void requestJoke() {
        DadJokesApi dadJokesApi = DadJokesServiceGenerator.createService(DadJokesApi.class);
        Call<DadJoke> jokeCall = dadJokesApi.getJoke();
        jokeCall.enqueue(new Callback<DadJoke>() {

            @Override
            public void onResponse(@NonNull Call<DadJoke> call, @NonNull Response<DadJoke> response) {
                DadJoke dadJoke = response.body();
                if (dadJoke != null) {
                    setText(dadJoke.getJoke());
                } else {
                    setText("Something went wrong");
                }
            }

            @Override
            public void onFailure(@NonNull Call<DadJoke> call, @NonNull Throwable t) {
                setText("Error occurred while fetching a joke: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void requestJokeFor(String term) {
        DadJokesApi dadJokesApi = DadJokesServiceGenerator.createService(DadJokesApi.class);
        Call<FatDadJoke> jokesCall = dadJokesApi.getJokesFor(term);
        jokesCall.enqueue(new Callback<FatDadJoke>() {

            @Override
            public void onResponse(@NonNull Call<FatDadJoke> call, @NonNull Response<FatDadJoke> response) {
                FatDadJoke dadJokes = response.body();
                if (dadJokes != null) {
                    StringBuilder jokesAsString = new StringBuilder();
                    jokesAsString.append(getString(R.string.jokes_title, term)).append("\n");
                    for (DadJoke joke: dadJokes.getJokes()) {
                        jokesAsString.append(joke.getJoke()).append("\n").append("\n");
                    }
                    setText(jokesAsString.toString());
                } else {
                    setText("Something went wrong");
                }
            }

            @Override
            public void onFailure(@NonNull Call<FatDadJoke> call, @NonNull Throwable t) {
                setText("Error occurred while fetching a joke: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void setText(String text) {
        responseTextView.setText(text);
    }
}