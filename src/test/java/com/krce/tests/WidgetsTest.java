package com.krce.tests;

import com.krce.WidgetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WidgetsTest extends BaseTest {
    @Test
    public void datePickerTest(){

        driver.get("https://demoqa.com/date-picker");

        WidgetsPage page = new WidgetsPage(driver);

        page.selectDate();

        Assert.assertEquals(page.getSelectedDate(), "05/28/2026");
    }
    @Test
    public void sliderTest(){

        driver.get("https://demoqa.com/slider");

        WidgetsPage page = new WidgetsPage(driver);

        page.moveSlider();

        Assert.assertEquals(page.getSliderValue(), "28");
    }
    @Test
    public void accordionTest(){

        driver.get("https://demoqa.com/accordian");

        WidgetsPage page = new WidgetsPage(driver);

        page.openSection2();

//        Assert.assertTrue(
//                page.isSection2Expanded()
//        );
        Assert.assertEquals(
                page.getAccordionState(),
                "true"
        );
    }

}

