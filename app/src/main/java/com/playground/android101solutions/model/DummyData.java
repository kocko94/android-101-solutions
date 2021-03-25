package com.playground.android101solutions.model;

import androidx.annotation.Nullable;

/**
 * Created on 23/03/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DummyData {
    @Nullable
    private final String imageUrl;
    private final String title;
    @Nullable
    private final String description;
    private final Type type;

    public DummyData(
            @Nullable String imageUrl,
            String title,
            @Nullable String description,
            Type type) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }
}

