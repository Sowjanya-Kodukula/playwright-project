package com.example.utils.helpers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtils {
    public static <T extends Comparable<T>> List<T> sortAscending(List<T> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Sort in descending order
    public static <T extends Comparable<T>> List<T> sortDescending(List<T> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
