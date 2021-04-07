package com.playground.android101solutions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.playground.android101solutions.datasource.DadJokesApi;
import com.playground.android101solutions.model.DadJoke;
import com.playground.android101solutions.service.DadJokesServiceGenerator;
import com.playground.android101solutions.util.Result;

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
        findViewById(R.id.btn_request).setOnClickListener(view -> requestJoke());
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
            }
        });
    }

    //<editor-fold desc="Second approach">
    private void requestJoke2() {
        DadJokesApi dadJokesApi = DadJokesServiceGenerator.createService(DadJokesApi.class);
        Call<DadJoke> jokeCall = dadJokesApi.getJoke();
        awaitJoke(jokeCall, (result) -> {
            if (result instanceof Result.Success) {
                DadJoke joke = (DadJoke) ((Result.Success) result).getData();
                setText(joke.getJoke());
            } else if (result instanceof Result.Error) {
                Throwable throwable = ((Result.Error) result).getException();
                setText(throwable.getMessage());
            }
        });
    }

    private void awaitJoke(Call<DadJoke> dadJokeCall, final IAwaitCall callCallback) {
        dadJokeCall.enqueue(new Callback<DadJoke>() {

            @Override
            public void onResponse(@NonNull Call<DadJoke> call, @NonNull Response<DadJoke> response) {
                DadJoke dadJoke = response.body();
                if (dadJoke != null) {
                    callCallback.onFinishedCall(new Result.Success(dadJoke));
                } else {
                    callCallback.onFinishedCall(new Result.Error(new Throwable("Something went wrong")));
                }
            }

            @Override
            public void onFailure(@NonNull Call<DadJoke> call, @NonNull Throwable t) {
                callCallback.onFinishedCall(new Result.Error(t));
            }
        });
    }

    interface IAwaitCall {
        void onFinishedCall(Result result);
    }
    //</editor-fold>

    private void setText(String text) {
        responseTextView.setText(text);
    }
}