package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    WebDriver driver;
    By form=By.className("card-up");//form locator globally
    By practiseForm=By.id("item-0");
    By firstname=By.id("firstName");
    By lastname=By.id("lastName");
    By email= By.id("userEmail");
    By gender=By.id("gender-radio-1");
    By number=By.id("userNumber");
    By dob=By.id("dateOfBirthInput");
    By month=By.className("react-datepicker__month-select");
    By year=By.className("react-datepicker__year-select");
    By subjects=By.id("subjectsInput");
    By hobbies=By.id("hobbies-checkbox-1");
    By pictures=By.id("uploadPicture");
    By address=By.id("currentAddress");
    By state=By.id("react-select-6-input");
    By city=By.id("city");
    By submit=By.id("submit");

    public FormPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickForm(){
        driver.findElement(form).click();
    }
    public void clickPractiseForm(){
        driver.findElement(practiseForm).click();
    }
    public void setName(){
        driver.findElement(firstname).sendKeys("syed");
        driver.findElement(lastname).sendKeys("riyaz");
    }
    public void setEmail(){
        driver.findElement(email).sendKeys("syedriyaz@gmail.com");
    }
    public void setGender(){
        driver.findElement(gender).click();
    }
    public void setNumber(){
        driver.findElement(number).sendKeys("1234");
    }
    public void setDob(){
        driver.findElement(dob).click();
        Select month = new Select(
                driver.findElement(month));

        month.selectByVisibleText("July");

        Select year = new Select(
                driver.findElement(year));

        year.selectByVisibleText("2004");
    }
    public void setSubjects(){
        driver.findElement(subjects).sendKeys("english");
    }
    public void setHobbies(){
        driver.findElement(hobbies).click();
    }
    public void setPictures(){
        driver.findElement(pictures).sendKeys("\"C:\\Users\\syedr\\OneDrive\\Pictures\\WHATSAPP\\fc b pic.jpg\"");
    }
    public void setAddress(){
        driver.findElement(address).sendKeys("krce");
    }
    public void setStateCity(){
        driver.findElement(state).sendKeys("NCR");
        driver.findElement(city).sendKeys("Delhi");
    }
    public void submit(){
        driver.findElement(submit).click();
    }
}

