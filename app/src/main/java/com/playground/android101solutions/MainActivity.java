package com.playground.android101solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String KEY_CALCULATED_NUMBER = "calculatedNumber";

    private TextView formulaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        formulaView = findViewById(R.id.formulaView);

        findViewById(R.id.button1).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button2).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button3).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button4).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button5).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button6).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button7).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button8).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.button9).setOnClickListener(v -> appendTextToScreen((Button) v));
        findViewById(R.id.plus).setOnClickListener(v -> appendTextToScreen((Button) v));

        findViewById(R.id.clear).setOnClickListener(this::onClearButtonClicked);
        findViewById(R.id.equal).setOnClickListener(this::onEqualButtonClicked);
    }

    private void appendTextToScreen(Button viewToAppendFrom) {
        CharSequence currentText = formulaView.getText();
        formulaView.setText(String.format("%s%s", currentText, viewToAppendFrom.getText()));
    }

    private void onEqualButtonClicked(View view) {
        int sum = calculateSum();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(KEY_CALCULATED_NUMBER, sum);
        startActivity(intent);
    }

    private void onClearButtonClicked(View view) {
        formulaView.setText(null);
    }

    private int calculateSum() {
        List<String> numbers = extractNumbersFrom(formulaView);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    private List<String> extractNumbersFrom(TextView formulaView) {
        String[] numbers = formulaView.getText().toString().split("\\+");
        if (numbers.length > 0 && !numbers[0].isEmpty()) {
            return Arrays.asList(numbers);
        } else {
            return Collections.emptyList();
        }
    }

}