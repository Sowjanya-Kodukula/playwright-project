package com.example.tests;
import com.example.utils.TestSetup;
import com.example.utils.Component;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ValidateLoginPage {
    public static void validateLoginPageTest() {

        try  {
            // Launch the browser (Chromium by default)

           Page page = TestSetup.setUpAndLogin();


            assertEquals("https://www.saucedemo.com/inventory.html",
                    page.url());
            assertEquals("Swag Labs",
                    Component.getText(page,".app_logo"));
            assertEquals("Products",
                    Component.getText(page, ".title"));
       }
        finally {
            TestSetup.tearDown();
        }
    }
    public static void main(String[] args) {
        validateLoginPageTest();
    }
}
