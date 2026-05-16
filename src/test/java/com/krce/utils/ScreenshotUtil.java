package com.krce.utils;

import com.krce.base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    private static final String SCREENSHOT_DIR = "screenshots/";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    /**
     * Captures a screenshot and saves it inside /screenshots/ folder.
     *
     * @param testName name of the test (used in filename)
     * @return absolute path of the saved screenshot, or null on failure
     */
    public static String captureScreenshot(String testName) {

        WebDriver currentDriver = BaseTest.getDriver();
        if (currentDriver == null) {
            System.err.println("[ScreenshotUtil] Driver is null – cannot capture screenshot.");
            return null;
        }

        try {
            // Build timestamped filename: TestName_20240512_143055_123.png
            String timestamp = LocalDateTime.now().format(FORMATTER);
            String sanitizedName = testName.replaceAll("[^a-zA-Z0-9_\\-]", "_");
            String fileName = sanitizedName + "_" + timestamp + ".png";

            // Ensure the screenshots/ directory exists
            Path screenshotDir = Paths.get(SCREENSHOT_DIR);
            Files.createDirectories(screenshotDir);

            // Take the screenshot
            File src = ((TakesScreenshot) currentDriver)
                    .getScreenshotAs(OutputType.FILE);

            // Copy to destination
            Path dest = screenshotDir.resolve(fileName);
            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("[ScreenshotUtil] Screenshot saved: " + dest.toAbsolutePath());
            return dest.toAbsolutePath().toString();

        } catch (IOException e) {
            System.err.println("[ScreenshotUtil] Failed to save screenshot: " + e.getMessage());
            return null;
        }
    }
}
