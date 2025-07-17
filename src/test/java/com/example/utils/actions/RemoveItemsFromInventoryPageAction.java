package com.example.utils.actions;

import com.example.utils.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RemoveItemsFromInventoryPageAction
        extends BaseTest
        implements AutoCloseable{

    private final Page page;
    private final List<String> itemNames;
    public RemoveItemsFromInventoryPageAction(Page page, List<String> itemNames) {
        this.page = page;
        this.itemNames = itemNames;
    }

    public void removeItemsFromInventoryAction() {
        for(String itemName : itemNames) {
            Locator item = page
                    .locator(".inventory_item")
                    .filter(new Locator.FilterOptions().setHasText(itemName));
            item
                    .locator("button:has-text('Remove')")
                    .click();
            assertThat(item
                    .locator("button:has-text('Remove')"))
                    .not()
                    .isVisible();
            assertThat(item
                    .locator("button:has-text('Add to cart')"))
                    .isVisible();
        }


    }

    @Override
    public void close(){

    }
}

