package com.acn.poc;

import java.util.List;
import java.util.Objects;

public final class DroolsUtils {

    private DroolsUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int toInt(final String str, final int defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static <T> T getLastElement(List<T> list) {
        Objects.requireNonNull(list, "List cannot be null");
        if (list.isEmpty()) {
            return null;
        }
        return list.getLast();
    }
}
