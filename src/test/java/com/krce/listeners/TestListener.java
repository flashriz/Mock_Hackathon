package com.krce.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.krce.base.BaseTest;
import com.krce.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestListener implements ITestListener to:
 *  1. Create an ExtentTest node for each test.
 *  2. Mark tests PASS / FAIL / SKIP in the report.
 *  3. Auto-capture a timestamped screenshot on failure and attach it to the report.
 */
public class TestListener implements ITestListener {

    /*
     * ThreadLocal so each parallel test thread has its own ExtentTest node.
     */
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    /* ------------------------------------------------------------------ */
    /*  Test started                                                        */
    /* ------------------------------------------------------------------ */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = BaseTest.extent
                .createTest(result.getMethod().getMethodName(),
                        result.getMethod().getDescription());
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    /* ------------------------------------------------------------------ */
    /*  Test PASSED                                                         */
    /* ------------------------------------------------------------------ */
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    /* ------------------------------------------------------------------ */
    /*  Test FAILED – capture screenshot and attach to report              */
    /* ------------------------------------------------------------------ */
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        // Log the exception message
        extentTest.get().log(Status.FAIL,
                "Test Failed: " + testName + " → " + result.getThrowable().getMessage());

        // Capture screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(testName);

        if (screenshotPath != null) {
            try {
                extentTest.get().fail(
                        "Screenshot on Failure",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
                );
            } catch (Exception e) {
                extentTest.get().log(Status.WARNING,
                        "Screenshot captured but could not be attached: " + e.getMessage());
            }
        } else {
            extentTest.get().log(Status.WARNING, "Screenshot could not be captured.");
        }
    }

    /* ------------------------------------------------------------------ */
    /*  Test SKIPPED                                                        */
    /* ------------------------------------------------------------------ */
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP,
                "Test Skipped: " + result.getMethod().getMethodName());
    }

    /* ------------------------------------------------------------------ */
    /*  Suite / Context hooks (not mandatory but good practice)            */
    /* ------------------------------------------------------------------ */
    @Override
    public void onStart(ITestContext context) {
        System.out.println("[TestListener] Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[TestListener] Suite Finished: " + context.getName());
    }
}













































