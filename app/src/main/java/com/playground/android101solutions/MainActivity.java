package com.playground.android101solutions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.playground.android101solutions.datasource.DummyDataService;
import com.playground.android101solutions.model.DummyData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupList();
    }

    private void setupList() {
        List<DummyData> dataSet = new DummyDataService(24).getData();
        ListAdapter adapter = new ListAdapter(dataSet);
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
    }
}