package com.playground.android101solutions.database;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class WordsDatabaseProvider {

    private static volatile WordsDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public WordsDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (this) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context, WordsDatabase.class, "wordsDatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

