package com.playground.android101solutions;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.playground.android101solutions.database.WordsDatabase;
import com.playground.android101solutions.database.WordsDatabaseProvider;
import com.playground.android101solutions.datasource.DataSourceDatabase;
import com.playground.android101solutions.repository.WordsRepository;
import com.playground.android101solutions.util.StringUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordsRepository wordsRepository;

    private TextView persistedWordsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persistedWordsTextView = findViewById(R.id.persistedWords);
        EditText wordEditText = findViewById(R.id.editText);

        findViewById(R.id.btnPersist).setOnClickListener(view -> persist(wordEditText.getText().toString()));
        findViewById(R.id.btnRetrieve).setOnClickListener(view -> showPersistedData());
        findViewById(R.id.btnDelete).setOnClickListener(view -> delete(wordEditText.getText().toString()));

        initialiseDatabase();
        showPersistedData();
    }

    private void initialiseDatabase() {
        WordsDatabaseProvider databaseProvider = new WordsDatabaseProvider();
        WordsDatabase database = databaseProvider.getDatabase(this);
        DataSourceDatabase dataSource = new DataSourceDatabase(database.getWordsDao(), WordsDatabaseProvider.databaseWriteExecutor);
        wordsRepository = new WordsRepository(dataSource);
    }

    private void persist(String word) {
        if (word != null) wordsRepository.save(word);
    }

    private void delete(String word) {
        if (word != null) wordsRepository.delete(word);
    }

    private void showPersistedData() {
        wordsRepository.retrieveAllWords((retrievedWords) -> {
            String word = retrievedWords.isEmpty() ? "Nothing is stored" : StringUtils.join(retrievedWords, "\n");
            updateScreenText(word);
        });
    }

    private void updateScreenText(String newText) {
        runOnUiThread(() -> persistedWordsTextView.setText(newText));
    }

}