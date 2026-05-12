package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablePage {
    By elements = By.xpath("//h5[text()='Elements']");

    By webTables =
            By.xpath("//span[text()='Web Tables']");

    By add =
            By.id("addNewRecordButton");

    By firstName =
            By.id("firstName");

    By lastName =
            By.id("lastName");

    By email =
            By.id("userEmail");

    By age =
            By.id("age");

    By salary =
            By.id("salary");

    By department =
            By.id("department");

    By submit =
            By.id("submit");

    WebDriver driver;

    By searchBox =
            By.id("searchBox");

    By deleteButton =
            By.id("delete-record-4");

    By rowsDropdown =
            By.xpath("//select");

    public WebTablePage(WebDriver driver){
        this.driver = driver;
    }

    public void openWebTables(){
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(elements)
        );

        driver.findElement(webTables).click();
    }

    public void addRecord(){

        // ✅ FIX 1: Wait until Add button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(add));

        driver.findElement(add).click();

        driver.findElement(firstName)
                .sendKeys("Riz");

        driver.findElement(lastName)
                .sendKeys("K");

        driver.findElement(email)
                .sendKeys("riz@gmail.com");

        driver.findElement(age)
                .sendKeys("22");

        driver.findElement(salary)
                .sendKeys("50000");

        driver.findElement(department)
                .sendKeys("QA");

        driver.findElement(submit).click();
    }

    public boolean isRecordAdded(){
        return driver.getPageSource()
                .contains("Riz");
    }

    public void searchRecord(){
        driver.findElement(searchBox)
                .sendKeys("Riz");
    }

    public boolean isCorrectRecordDisplayed(){
        return driver.getPageSource()
                .contains("Riz");
    }

    public void deleteRecord(){
        driver.findElement(deleteButton)
                .click();
    }

    public boolean isRecordDeleted(){
        return !driver.getPageSource()
                .contains("Riz");
    }

    public void changeRowsPerPage(){

        // ✅ FIX 2: Wait until the rows dropdown is visible before selecting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rowsDropdown));

        Select rows = new Select(
                driver.findElement(rowsDropdown)
        );
        rows.selectByVisibleText("Show 10");
    }

    public String getRowsValue(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rowsDropdown));

        Select rows = new Select(
                driver.findElement(rowsDropdown)
        );
        return rows.getFirstSelectedOption()
                .getText();
    }
}