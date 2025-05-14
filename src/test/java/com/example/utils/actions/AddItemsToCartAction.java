package com.example.utils.actions;

import com.example.utils.TestSetup;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddItemsToCartAction
implements AutoCloseable {

    public static void addItemsToCartAction(){
        Page page = null;
        page = TestSetup.setUpAndLogin();

        Locator items = page.locator(".inventory_item");
        int randomIndex = new Random().nextInt(items.count());

        // Get the selected item name
        String selectedItemName = items.nth(randomIndex)
                .locator(".inventory_item_name")
                .innerText()
                .trim();

        // Add the selected item to cart
        items.nth(randomIndex)
                .locator("button:has-text('Add to cart')")
                .click();

        page.click(".shopping_cart_link");

        Locator cartItems = page
                .locator(".cart_item .inventory_item_name");

        Assertions.assertTrue(cartItems.allInnerTexts().stream()
                .map(String::trim)
                .anyMatch(name -> name.equals(selectedItemName)));

    }
    @Override
    public void close() {
        TestSetup.tearDown();
    }
}
