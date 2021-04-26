package com.playground.android101solutions.datasource;

import androidx.annotation.NonNull;

import com.playground.android101solutions.util.ResultCallback;

import java.util.List;

/**
 * Created on 18/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface DataSource {

    void save(@NonNull String word);

    void delete(@NonNull String word);

    void retrieveWord(final ResultCallback<String> result);

    void retrieveAllWords(final ResultCallback<List<String>> result);
}

