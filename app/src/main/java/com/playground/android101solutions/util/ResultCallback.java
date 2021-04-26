package com.playground.android101solutions.util;

import androidx.annotation.Nullable;

public interface ResultCallback<T> {
    void setResult(@Nullable T result);
}
