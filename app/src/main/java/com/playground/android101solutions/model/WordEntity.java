package com.playground.android101solutions.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
@Entity
public class WordEntity {

    @NonNull
    @PrimaryKey
    public final String word;

    public WordEntity(@NonNull String word) {
        this.word = word;
    }
}
