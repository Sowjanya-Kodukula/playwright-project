package com.example.utils.actions;

import com.example.utils.BaseTest;
import com.example.utils.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateHomePageAction
extends BaseTest
implements AutoCloseable{

    public ValidateHomePageAction(){
        setUp();
    }

    public  void validateHomePageAction() {
        assertEquals("https://www.saucedemo.com/inventory.html",
                page.url());
        assertEquals("Swag Labs",
                Component.getText(page,".app_logo"));
        assertEquals("Products",
                Component.getText(page, ".title"));
    }

    @Override
    public void close() {
        tearDown();
    }
}
