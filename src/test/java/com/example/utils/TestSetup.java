package com.example.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;


public class TestSetup {
    private static Playwright playwright;
    private static Browser browser;

    private static void initialize() {
        if (playwright == null) {
            playwright = Playwright.create();  // Initialize Playwright instance
        }
        if (browser == null) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));  // Initialize Browser instance
        }
    }
    public static Page setUpAndLogin() {
        initialize();

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.saucedemo.com/");
        page.locator("#user-name").fill("standard_user");
        page.locator("#password").fill("secret_sauce");
        page.locator("#login-button").click();
        page.waitForURL("**/inventory.html");

        return page;
    }

    public static void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
