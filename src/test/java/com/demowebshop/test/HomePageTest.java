package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    HomePage home;

    @Test(priority = 1,enabled = true,description = "TestCase_001 Verification of Home Page Title")
    public void verifyHomePageTitle() {
        home = new HomePage(driver);
        String expectedTitle = "Demo Web Shop";
        String actualTitle = home.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle," Home Page title doesn't match");
    }
}
