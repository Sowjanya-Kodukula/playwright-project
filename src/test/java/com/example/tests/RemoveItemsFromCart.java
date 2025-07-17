package com.example.tests;

import com.example.utils.actions.AddItemsToCartAction;
import com.example.utils.actions.RemoveItemsFromCartAction;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class RemoveItemsFromCart {

    @Test
    public void removeItemsFromCart() {
        try(AddItemsToCartAction add = new AddItemsToCartAction()) {
            add.addItemsToCartAction();
            Page page = add.getPage();

            // Take screenshot after adding items
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("build/test-results/screenshots/after-adding-items.png")));

            try (RemoveItemsFromCartAction remove =
                    new RemoveItemsFromCartAction(add.getPage())) {
                remove.removeItemsFromCartAction();

                System.out.println("Saving to: " + Paths.get("build/test-results/screenshots/after-adding-items.png").toAbsolutePath());

                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(Paths.get("build/test-results/screenshots/after-removing-items.png")));

            }
        }
    }
}
