package com.playground.android101solutions.util;

import androidx.annotation.NonNull;

public abstract class Result {

    public static final class Success extends Result {
        @NonNull
        private final Object data;

        public Success(@NonNull Object data) {
            this.data = data;
        }

        @NonNull
        public Object getData() {
            return data;
        }
    }

    public static final class Error extends Result {
        @NonNull
        private final Throwable exception;

        public Error(@NonNull Throwable exception) {
            this.exception = exception;
        }

        @NonNull
        public Throwable getException() {
            return exception;
        }
    }
}