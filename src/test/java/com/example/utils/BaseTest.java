package com.example.utils;

import com.microsoft.playwright.Page;

public class BaseTest{
    protected Page page;

    public void setUp() {
        page = TestSetup.setUpAndLogin();
    }

    public void tearDown() {
        TestSetup.tearDown();
    }

}
