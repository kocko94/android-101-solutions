package com.playground.android101solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String KEY_CALCULATED_NUMBER = "calculatedNumber";

    private final List<Integer> numbers = new ArrayList<>();
    private String currentNumber = "";
    private TextView formulaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        formulaView = findViewById(R.id.formulaView);

        findViewById(R.id.button1).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button2).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button3).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button4).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button5).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button6).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button7).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button8).setOnClickListener(v -> onNumberClicked((Button) v));
        findViewById(R.id.button9).setOnClickListener(v -> onNumberClicked((Button) v));

        findViewById(R.id.plus).setOnClickListener(this::onPlusButtonClicked);
        findViewById(R.id.clear).setOnClickListener(this::onClearButtonClicked);
        findViewById(R.id.equal).setOnClickListener(this::onEqualButtonClicked);
    }

    private void onEqualButtonClicked(View view) {
        addCurrentNumberToValues();
        int sum = calculateSumFor(numbers);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(KEY_CALCULATED_NUMBER, sum);
        startActivity(intent);
    }

    private void onClearButtonClicked(View view) {
        numbers.clear();
        clearCurrentNumber();
        formulaView.setText(null);
    }

    private void onPlusButtonClicked(View button) {
        addCurrentNumberToValues();
        appendTextToFormulaView("+");
        clearCurrentNumber();
    }

    private void addCurrentNumberToValues() {
        Integer value = Integer.valueOf(currentNumber);
        numbers.add(value);
    }

    private void clearCurrentNumber() {
        currentNumber = "";
    }

    private void onNumberClicked(Button origin) {
        CharSequence buttonText = origin.getText();

        currentNumber += buttonText;

        appendTextToFormulaView(buttonText);
    }

    private void appendTextToFormulaView(CharSequence buttonText) {
        CharSequence currentText = formulaView.getText();
        formulaView.setText(String.format("%s%s",currentText, buttonText));
    }

    private int calculateSumFor(List<Integer> numbers) {
        int result = 0;
        for(int number: numbers) {
            result += number;
        }
        return result;
    }

}