package com.playground.android101solutions.util;

import java.util.List;

/**
 * Created on 26/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class StringUtils {

    public static <T> String join(List<T> list, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for(T object: list) {
            stringBuilder.append(object.toString()).append(separator);
        }
        return stringBuilder.toString();
    }
}
