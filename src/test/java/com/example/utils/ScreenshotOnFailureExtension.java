package com.example.utils;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ScreenshotOnFailureExtension implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        Object testInstance = context.getRequiredTestInstance();

        if (testInstance instanceof BaseTest) {

            BaseTest baseTest = (BaseTest) testInstance;
            Page page = baseTest.page;

            if (page != null && !page.isClosed()) {
                try {
                    Path screenshotDir = Paths.get("test-results");
                    Files.createDirectories(screenshotDir);

                    String testName = context.getDisplayName()
                            .replaceAll("[^a-zA-Z0-9.-]", "_");

                    Path screenshotPath =
                            screenshotDir.resolve(testName + ".png");

                    page.screenshot(new Page.ScreenshotOptions()
                            .setPath(screenshotPath)
                            .setFullPage(true));

                    System.out.println(
                            "Screenshot saved to: "
                                    + screenshotPath.toAbsolutePath()
                    );

                } catch (Exception e) {
                    System.out.println(
                            "Failed to capture screenshot: "
                                    + e.getMessage()
                    );
                }
            }
        }
    }
}
