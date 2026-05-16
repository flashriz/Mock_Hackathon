package com.krce.tests;

import com.krce.page.FormPage;

import com.krce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    @Test(priority = 1)
    public void testForm(){

        FormPage form = new FormPage(driver);

        form.clickForm();

        form.clickPractiseForm();

        form.setName();

        form.setEmail();

        form.setGender();

        form.setNumber();

        form.setDob();

        form.setSubjects();

        form.setHobbies();

        form.setPictures();

        form.setAddress();

        form.setStateCity();

        form.submit();

        Assert.assertTrue(form.successMessage());
        Assert.assertTrue(form.isGenderSelected());
        Assert.assertTrue(form.isHobbySelected());
        driver.navigate().refresh();
    }
    @Test(priority = 2)
    public void emptyMandatoryFieldsTest(){
        driver.get("https://demoqa.com/automation-practice-form");
        FormPage form = new FormPage(driver);
        form.submit();

        Assert.assertFalse(form.successMessage());
    }
}