package com.playground.android101solutions.repository;

import androidx.annotation.NonNull;

import com.playground.android101solutions.datasource.DataSource;
import com.playground.android101solutions.util.ResultCallback;

import java.util.List;

/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class WordsRepository {

    private final DataSource wordsDataSource;

    public WordsRepository(DataSource wordsDataSource) {
        this.wordsDataSource = wordsDataSource;
    }

    public void save(@NonNull String word) {
        wordsDataSource.save(word);
    }

    public void delete(@NonNull String word) {
        wordsDataSource.delete(word);
    }

    public void retrieveWord(ResultCallback<String> result) {
        wordsDataSource.retrieveWord(result);
    }

    public void retrieveAllWords(ResultCallback<List<String>> result) {
        wordsDataSource.retrieveAllWords(result);
    }

}
