package com.example.utils.actions;

import com.example.utils.BaseTest;
import com.example.utils.TestSetup;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddItemsToCartAction
extends BaseTest
implements AutoCloseable {

    public AddItemsToCartAction() {
        setUp(); // initialize Playwright, browser, context, and login
    }

    public void addItemsToCartAction(){

        Locator items = page.locator(".inventory_item");
        int totalItems = items.count();
        // Determine how many items to add: between 2 and totalItems
        int numberOfItemsToAdd = new Random().nextInt(totalItems - 1) + 2;

        // Get the selected item name
        List<Integer> randomIndexes = new Random()
                .ints(0, totalItems)
                .distinct()
                .limit(numberOfItemsToAdd)
                .boxed()
                .collect(Collectors.toList());


        List<String> selectedItemNames = randomIndexes.stream().map(index -> {
            String itemName = items.nth(index)
                    .locator(".inventory_item_name")
                    .innerText()
                    .trim();

            items.nth(index)
                    .locator("button:has-text('Add to cart')")
                    .click();

            return itemName;
        }).collect(Collectors.toList());

        // Verify item count on shopping cart icon

        Locator shoppingCartLink = page
                .locator(".shopping_cart_badge");

        int itemCount = Integer.parseInt(shoppingCartLink
                .textContent()
                        .trim());
        Assertions.assertEquals (numberOfItemsToAdd,
                itemCount,
                "Item Count mismatch");

        page.click(".shopping_cart_link");

        List <String> cartItems = page
                .locator(".cart_item .inventory_item_name")
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());


        Assertions.assertTrue(cartItems.containsAll(selectedItemNames));


    }
//    public void undoLogic() {
//        // Logic to remove item from the cart to reset the system state
//        Locator cartItem = page.locator(".cart_item .inventory_item_name");
//        cartItem
//                .locator("button:has-text('Remove')")
//                .click();
//    }
    @Override
    public void close(){
//        undoLogic();
        tearDown();
    }

}
