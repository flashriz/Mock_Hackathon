package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    WebDriver driver;

    public FramesPage(WebDriver driver){
        this.driver=driver;
    }
    By frameHeading = By.id("sampleHeading");

    By childText = By.tagName("p");

    By mainHeading = By.xpath("//div[text()='Frames']");
    public void switchToFrame(){

        driver.switchTo().frame("frame1");
    }
    public String getFrameText(){

        return driver.findElement(frameHeading).getText();
    }
    public void switchToParentFrame(){

        driver.switchTo().frame("frame1");
    }
    public void switchToChildFrame(){

        driver.switchTo().frame(0);
    }
    public String getChildFrameText(){

        return driver.findElement(childText).getText();
    }
    public void switchBackToMainPage(){

        driver.switchTo().defaultContent();
    }
    public String getPageTitle(){

        return driver.getTitle();
    }
}
