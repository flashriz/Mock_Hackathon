package com.krce.tests;

import com.krce.page.AlertsWindowsPage;
import com.krce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsWindowsTest extends BaseTest {
    @Test
    public void simpleAlertTest(){

        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openAlerts();

        page.triggerSimpleAlert();

        Assert.assertEquals(page.getAlertText(), "You clicked a button");

        page.acceptAlert();
    }
    @Test
    public void confirmAlertTest(){

        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openAlerts();

        page.triggerConfirmAlert();

        page.dismissAlert();

        Assert.assertEquals(page.getConfirmResult(), "You selected Cancel");
    }
    @Test
    public void promptAlertTest(){

        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openAlerts();

        page.triggerPromptAlert();

        page.enterPromptText();

        Assert.assertEquals(page.getPromptResult(), "You entered Riz");
    }
    @Test
    public void newTabTest(){

        AlertsWindowsPage page = new AlertsWindowsPage(driver);

        page.openBrowserWindows();

        page.openNewTab();

        page.switchToNewTab();

        Assert.assertTrue(page.getCurrentURL().contains("sample"));
    }
}
