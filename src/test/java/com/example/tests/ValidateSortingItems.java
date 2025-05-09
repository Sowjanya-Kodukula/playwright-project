package com.example.tests;
import com.example.utils.actions.ValidateSortingItemsAction;

import org.junit.jupiter.api.Test;
public class ValidateSortingItems {

    @Test
    public void testValidateSortingItems() {
        try(ValidateSortingItemsAction a = new ValidateSortingItemsAction()){
            a.validateSortingItems();
        } finally {

        }
    }
}
