package com.krce.tests;

import com.krce.FramesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{
    @Test
    public void iframeTest(){

        driver.get("https://demoqa.com/frames");

        FramesPage page = new FramesPage(driver);

        page.switchToFrame();

        Assert.assertEquals(page.getFrameText(), "This is a sample page");
    }
    @Test
    public void nestedIframeTest(){

        driver.get("https://demoqa.com/nestedframes");

        FramesPage page = new FramesPage(driver);

        page.switchToParentFrame();

        page.switchToChildFrame();

        Assert.assertEquals(page.getChildFrameText(), "Child Iframe");
    }
    @Test
    public void switchBackToMainPageTest(){

        driver.get("https://demoqa.com/frames");

        FramesPage page = new FramesPage(driver);

        page.switchToFrame();

        page.switchBackToMainPage();

        Assert.assertEquals(page.getPageTitle(), "demosite");
    }
}
