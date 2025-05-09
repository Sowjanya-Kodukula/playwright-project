package com.example.utils.actions;
import com.example.utils.TestSetup;

import com.microsoft.playwright.Page;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidateSortingItemsAction
implements AutoCloseable {
    public static void validateSortingItems() {
        Page page = null;

            page = TestSetup.setUpAndLogin();

            // Default sort by name (ascending)
            List<String> actualNames = page.locator(".inventory_item")
                    .allInnerTexts()
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());

            List<Double> defaultPriceList = page.locator(".inventory_item_price")
                    .allInnerTexts()
                    .stream()
                    .map(text -> text.replace("$", "").trim())
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            assertEquals(actualNames
                    .stream()
                    .sorted()
                    .collect(Collectors.toList()),
                    actualNames);

            // Name sort Z to A
            page.selectOption(".product_sort_container", "za");
            List<String> reverseOrderedNames = page.locator(".inventory_item")
                    .allInnerTexts()
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());

            assertEquals(actualNames
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList()),
                    reverseOrderedNames);

            // Price Low to High
            page.selectOption(".product_sort_container", "lohi");
            List<Double> lowToHiPrices = page.locator(".inventory_item_price")
                    .allInnerTexts()
                    .stream()
                    .map(text -> text.replace("$", "").trim())
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            assertEquals(defaultPriceList
                    .stream()
                    .sorted()
                    .collect(Collectors.toList()),
                    lowToHiPrices);

            // Price High to Low
            page.selectOption(".product_sort_container", "hilo");
            List<Double> hiToLoPrices = page.locator(".inventory_item_price")
                    .allInnerTexts()
                    .stream()
                    .map(text -> text.replace("$", "").trim())
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            assertEquals(defaultPriceList
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList()),
                    hiToLoPrices);
    }
    @Override
    public void close() {
        TestSetup.tearDown();
    }
}

