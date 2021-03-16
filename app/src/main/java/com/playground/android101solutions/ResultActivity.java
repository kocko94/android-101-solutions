package com.playground.android101solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int calculatedNumber = getIntent().getIntExtra(MainActivity.KEY_CALCULATED_NUMBER, 0);
        TextView result = findViewById(R.id.result);
        String text = getString(R.string.calculated_result, calculatedNumber);
        result.setText(text);
    }
}