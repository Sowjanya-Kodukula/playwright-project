package com.example.utils;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Component {
    public static String getText(Page page, String selector) {
        return page.locator(selector).textContent();
    }

    public static void click(Page page, String selector) {
        page.locator(selector).click();
    }

    public static void typeText(Page page, String selector, String text) {
        page.locator(selector).fill(text);
    }

    public static void selectSortOption(Page page, String optionValue) {
        page.selectOption(".product_sort_container", optionValue);
    }

    // Generic method to extract and transform text
    // <T> - Generic type could be String, Double
    // or any type
    // Function - java functional interface that takes
    // String as input and returns value type T
    public static <T> List<T> getList(Page page,
                                      String selector,
                                      DataType type,
                                      Class<T> classT) {
        return page.locator(selector)
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .map(type::transform) // Apply transformation from DataType enum
                .map(classT::cast) // Cast to the correct type (generic type T)
                .collect(Collectors.toList());
    }


}