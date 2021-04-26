package com.playground.android101solutions.datasource;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.playground.android101solutions.model.WordEntity;

import java.util.List;

/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
@Dao
public interface WordsDao {

    @Query("SELECT word FROM WordEntity")
    List<String> findAll();

    @Query("SELECT word FROM WordEntity LIMIT 1")
    String findSingle();

    @Query("SELECT * FROM WordEntity WHERE word=:searchWord LIMIT 1")
    WordEntity find(String searchWord);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WordEntity wordEntity);

    @Delete
    void delete(WordEntity wordEntity);
}
