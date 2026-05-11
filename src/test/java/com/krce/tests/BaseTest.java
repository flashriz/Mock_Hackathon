package com.krce.tests;

import com.krce.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    ConfigReader config=new ConfigReader();
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver =new ChromeDriver();//initialize chrome browser
        wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.timeout())));// getting timeout from config files
        driver.get(config.getURL());
        driver.manage().window().maximize();//maximize the screen
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

}
