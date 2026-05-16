package com.krce.tests;

import com.krce.page.WebTablePage;
import com.krce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {
    @Test(priority = 1)
    public void addRowTest(){
        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();

        table.addRecord();

        Assert.assertTrue(
                table.isRecordAdded()
        );
    }
    @Test(priority = 2)
    public void searchRecordTest(){

        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();
        table.addRecord();
        table.searchRecord();

        Assert.assertTrue(
                table.isCorrectRecordDisplayed()
        );
    }
    @Test(priority = 3)
    public void deleteRecordTest(){

        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();

        table.addRecord();

        table.deleteRecord();

        Assert.assertTrue(
                table.isRecordDeleted()
        );
    }
    @Test(priority = 4)
    public void paginationTest(){

        WebTablePage table =
                new WebTablePage(driver);

        table.openWebTables();

        table.changeRowsPerPage();

        Assert.assertEquals(
                table.getRowsValue(),
                "Show 10"
        );
    }
}
