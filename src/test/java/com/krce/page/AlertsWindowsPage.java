package com.krce.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AlertsWindowsPage {
    WebDriver driver;
    public AlertsWindowsPage(WebDriver driver){
        this.driver = driver;
    }
    By alertsFrameWindows = By.xpath("//h5[text()='Alerts, Frame & Windows']");

    By alerts = By.xpath("//span[text()='Alerts']");

    By simpleAlertButton = By.id("alertButton");

    By confirmButton = By.id("confirmButton");

    By confirmResult = By.id("confirmResult");

    By promptButton = By.id("promtButton");
    By promptResult = By.id("promptResult");

    By browserWindows = By.xpath("//span[normalize-space()='Browser Windows']");

    By newTabButton = By.id("tabButton");
    public void openAlerts(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(alertsFrameWindows)
        );

        js.executeScript("arguments[0].click();", driver.findElement(alertsFrameWindows));

        wait.until(ExpectedConditions.visibilityOfElementLocated(alerts)
        );

        driver.findElement(alerts).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(simpleAlertButton));
    }
    public void triggerSimpleAlert(){

        driver.findElement(simpleAlertButton).click();
    }
    public void acceptAlert(){

        Alert alert = driver.switchTo().alert();

        alert.accept();
    }
    public String getAlertText(){

        Alert alert = driver.switchTo().alert();

        return alert.getText();
    }
    public void triggerConfirmAlert(){

        driver.findElement(confirmButton).click();
    }
    public void dismissAlert(){

        Alert alert = driver.switchTo().alert();

        alert.dismiss();
    }
    public String getConfirmResult(){

        return driver.findElement(confirmResult).getText();
    }
    public void triggerPromptAlert(){

        driver.findElement(promptButton).click();
    }
    public void enterPromptText(){

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Riz");

        alert.accept();
    }
    public String getPromptResult(){

        return driver.findElement(promptResult).getText();
    }
    public void openBrowserWindows(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", driver.findElement(alertsFrameWindows));

        js.executeScript("arguments[0].click();", driver.findElement(browserWindows));
    }
    public void openNewTab(){

        driver.findElement(newTabButton).click();
    }
    public void switchToNewTab(){

        Set<String> windows = driver.getWindowHandles();

        for(String window : windows){

            driver.switchTo().window(window);
        }
    }
    public String getCurrentURL(){

        return driver.getCurrentUrl();
    }
}
