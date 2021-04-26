package com.playground.android101solutions.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.playground.android101solutions.datasource.WordsDao;
import com.playground.android101solutions.model.WordEntity;

/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
@Database(entities = {WordEntity.class}, version = 1, exportSchema = false)
public abstract class WordsDatabase extends RoomDatabase {
   public abstract WordsDao getWordsDao();
}
