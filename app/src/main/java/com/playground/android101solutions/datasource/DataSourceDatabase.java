package com.playground.android101solutions.datasource;

import androidx.annotation.NonNull;

import com.playground.android101solutions.model.WordEntity;
import com.playground.android101solutions.util.ResultCallback;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DataSourceDatabase implements DataSource {

    private final WordsDao wordsDao;
    private final ExecutorService databaseExecutor;

    public DataSourceDatabase(WordsDao wordsDao, ExecutorService databaseExecutor) {
        this.wordsDao = wordsDao;
        this.databaseExecutor = databaseExecutor;
    }

    @Override
    public void save(@NonNull String word) {
        final WordEntity entity = new WordEntity(word);
        databaseExecutor.execute(() -> wordsDao.insert(entity));
    }

    @Override
    public void delete(@NonNull String word) {
        final WordEntity entity = new WordEntity(word);
        databaseExecutor.execute(() -> wordsDao.delete(entity));
    }

    @Override
    public void retrieveWord(final ResultCallback<String> result) {
        databaseExecutor.execute(() -> result.setResult(wordsDao.findSingle()));
    }

    @Override
    public void retrieveAllWords(final ResultCallback<List<String>> result) {
        databaseExecutor.execute(() -> result.setResult(wordsDao.findAll()));
    }
}
