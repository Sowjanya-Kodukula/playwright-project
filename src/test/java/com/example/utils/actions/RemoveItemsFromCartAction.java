package com.example.utils.actions;

import com.example.utils.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveItemsFromCartAction
        extends BaseTest
        implements AutoCloseable {

    private final Page page;
    public RemoveItemsFromCartAction(Page page) {
        this.page = page;
    }

    public void removeItemsFromCartAction() {

        List<String> cartItems = page
                .locator(".cart_item .inventory_item_name")
                .allInnerTexts()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());

        for (String itemName : cartItems) {
            page.locator(".cart_item")
                    .filter(new Locator.FilterOptions().setHasText(itemName))
            .locator("button:has-text('Remove')").click();
        }


    }

    @Override
    public void close(){

    }
}

