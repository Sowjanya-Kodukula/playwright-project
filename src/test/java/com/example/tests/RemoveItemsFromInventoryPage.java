package com.example.tests;

import com.example.utils.actions.AddItemsToCartAction;
import com.example.utils.actions.RemoveItemsFromInventoryPageAction;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class RemoveItemsFromInventoryPage {
    @Test
    public void removeItemsFromCart() {
        try(AddItemsToCartAction add = new AddItemsToCartAction()) {
            add.addItemsToCartAction();
            Page page = add.getPage();
            page.click("#continue-shopping");
            try (RemoveItemsFromInventoryPageAction remove =
                         new RemoveItemsFromInventoryPageAction(page, add.getSelectedItemNames())) {
                remove.removeItemsFromInventoryAction();

            }
        }
    }
}
