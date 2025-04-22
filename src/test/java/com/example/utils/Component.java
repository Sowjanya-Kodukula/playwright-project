package com.example.utils;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
public class Component {
    public static String getText(Page page, String selector) {
        return page.locator(selector).textContent();
    }

    public static void click(Page page, String selector) {
        page.locator(selector).click();
    }

    public static void typeText(Page page, String selector, String text) {
        page.locator(selector).fill(text);
    }

}
