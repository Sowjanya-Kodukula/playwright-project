package com.example.tests;

import com.example.utils.actions.AddItemsToCartAction;

import org.junit.jupiter.api.Test;

public class AddItemsToCart {
    @Test
    public void addItemsToCart() {
        try(AddItemsToCartAction a = new AddItemsToCartAction()){
            a.addItemsToCartAction();
        }
    }
}
