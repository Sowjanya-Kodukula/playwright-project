package com.example.utils.actions;

import com.example.utils.BaseTest;
import com.example.utils.Component;
import com.example.utils.DataType;

import static com.example.utils.helpers.SortUtils.sortAscending;
import static com.example.utils.helpers.SortUtils.sortDescending;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidateSortingItemsAction
extends BaseTest
implements AutoCloseable {

    public ValidateSortingItemsAction() {
        setUp();
    }
    public void validateSortingItemsAction() {

            // Default sort by name (ascending)
            List<String> itemNames = Component.getList(page,
                    ".inventory_item",
                    DataType.NAME,
                    String.class);

// Verify sort by names in ascending order
            assertEquals(sortAscending(itemNames),
                    itemNames);

            // Name sort Z to A
            page.selectOption(".product_sort_container", "za");
            List<String> reverseOrderedNames = Component.getList(page,
                    ".inventory_item",
                    DataType.NAME,
                    String.class);

            assertEquals(sortDescending(itemNames),
                    reverseOrderedNames);

            // Price Low to High
            page.selectOption(".product_sort_container", "lohi");
            List<Double> lowToHiPrices = Component.getList(page,
                    ".inventory_item_price",
                    DataType.PRICE,
                    Double.class);

            assertEquals(sortAscending(lowToHiPrices),
                    lowToHiPrices);

            // Price High to Low
            page.selectOption(".product_sort_container", "hilo");
            List<Double> hiToLoPrices = Component.getList(page,
                    ".inventory_item_price",
                    DataType.PRICE,
                    Double.class);

            assertEquals(sortDescending(lowToHiPrices),
                    hiToLoPrices);
    }
    @Override
    public void close() {
        tearDown();
    }
}

