package com.playground.android101solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        resultView = findViewById(R.id.result);

        findViewById(R.id.button1).setOnClickListener(v -> updateTextView(resultView, "1"));
        findViewById(R.id.button2).setOnClickListener(v -> updateTextView(resultView, "2"));
        findViewById(R.id.button3).setOnClickListener(v -> updateTextView(resultView, "3"));
        findViewById(R.id.button4).setOnClickListener(v -> updateTextView(resultView, "4"));
        findViewById(R.id.button5).setOnClickListener(v -> updateTextView(resultView, "5"));
        findViewById(R.id.button6).setOnClickListener(v -> updateTextView(resultView, "6"));
        findViewById(R.id.button7).setOnClickListener(v -> updateTextView(resultView, "7"));
        findViewById(R.id.button8).setOnClickListener(v -> updateTextView(resultView, "8"));
        findViewById(R.id.button9).setOnClickListener(v -> updateTextView(resultView, "9"));
    }

    private void updateTextView(TextView view, String value) {
        view.setText(value);
    }

    //<editor-fold desc="Another (better) approach">
    private void setupViews2() {
        findViewById(R.id.button1).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button2).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button3).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button4).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button5).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button6).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button7).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button8).setOnClickListener(v -> updateTextView((Button) v, resultView));
        findViewById(R.id.button9).setOnClickListener(v -> updateTextView((Button) v, resultView));
    }

    private void updateTextView(Button origin, TextView result) {
        result.setText(origin.getText());
    }
    //</editor-fold>

}