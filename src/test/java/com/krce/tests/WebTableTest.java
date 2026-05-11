package com.krce.tests;

import com.krce.WebTablePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest{
    @Test
    public void addRowTest(){
        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();
        table.addRecord();

        Assert.assertTrue(table.isRecordAdded());
    }
    @Test
    public void searchRecordTest(){

        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();

        table.searchRecord();

        Assert.assertTrue(table.isCorrectRecordDisplayed()
        );
    }
    @Test
    public void deleteRecordTest(){

        WebTablePage table = new WebTablePage(driver);

        table.openWebTables();

        table.addRecord();

        table.deleteRecord();

        Assert.assertTrue(table.isRecordDeleted()
        );
    }
    @Test
    public void paginationTest(){

        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();

        table.changeRowsPerPage();

        Assert.assertEquals(table.getRowsValue(), "Show 10");
    }
}
