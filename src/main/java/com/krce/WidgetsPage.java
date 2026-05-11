package com.krce;

import org.openqa.selenium.*;

public class WidgetsPage {
    WebDriver driver;
    By dateInput = By.id("datePickerMonthYearInput");

    By slider = By.className("range-slider");

    By section2 = By.xpath("//*[contains(text(),'Where does it come from?')]");
    By section2Content = By.xpath("//*[contains(text(),'Contrary to popular belief')]");

    public WidgetsPage(WebDriver driver){
        this.driver=driver;
    }

    public void selectDate(){

        WebElement date = driver.findElement(dateInput);

        date.sendKeys(Keys.CONTROL + "a");

        date.sendKeys("05/28/2026");

        date.sendKeys(Keys.ENTER);
    }
    public String getSelectedDate(){

        return driver.findElement(dateInput).getAttribute("value");
    }
    public void moveSlider(){

        WebElement slide = driver.findElement(slider);

        slide.sendKeys(Keys.ARROW_RIGHT);

        slide.sendKeys(Keys.ARROW_RIGHT);

        slide.sendKeys(Keys.ARROW_RIGHT);
    }
    public String getSliderValue(){

        return driver.findElement(slider).getAttribute("value");
    }
    public void openSection2(){

        WebElement element = driver.findElement(section2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);

        js.executeScript("arguments[0].click();", element);
    }
//    public boolean isSection2Expanded(){
//
//        return driver.findElement(section2Content)
//                .isDisplayed();
    //}
    public String getAccordionState(){

        return driver.findElement(section2).getAttribute("aria-expanded");
    }
}
