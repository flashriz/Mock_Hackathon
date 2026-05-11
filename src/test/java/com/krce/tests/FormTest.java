package com.krce.tests;

import com.krce.FormPage;

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
    }
    @Test(priority = 2)
    public void emptyMandatoryFieldsTest(){

        FormPage form = new FormPage(driver);

        form.clickForm();

        form.clickPractiseForm();

        form.submit();

        Assert.assertFalse(form.successMessage());
    }
}