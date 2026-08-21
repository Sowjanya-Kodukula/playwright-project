package test.java.com.example.tests;

import com.example.utils.actions.AddItemsToCartAction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddItemsToCart {
    @Test
    public void addItemsToCartandVerifyShoppingBadge() {
        try(AddItemsToCartAction a = new AddItemsToCartAction()){

            a.addItemsToCartAction();

        }
    }

    @Test
    public void addItemsToCartAndRemoveItemsInHomePage() {

        try (AddItemsToCartAction a = new AddItemsToCartAction()) {

            a.addItemsToCartAction();

            a.removeSelectedItemsFromHomePage();

            Assertions.assertFalse(a
                    .getPage()
                    .locator(".shopping_cart_badge")
                    .isVisible());

        }

    }

    @Test

    public void addItemsToCartAndVerifyItemsInShoppingCartPage() {

        try(AddItemsToCartAction a = new AddItemsToCartAction()){

            a.addItemsToCartAction();

            a.goToShoppingCartAndVerifyItems();

        }

    }
}
