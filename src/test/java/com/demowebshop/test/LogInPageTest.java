package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LogInPage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LogInPageTest extends Base {
    HomePage home;
    LogInPage login;
    MyAccountPage account;
    ExcelUtility excel=new ExcelUtility();

    @Test(priority = 2,enabled = true,description = "TestCase_001_Verify valid User Login")
    public void verifyLogin() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> data=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "LoginPage");
        login.enterUserName(data.get(3));
        login.enterPassword(data.get(4));
        account=login.clickOnLoginButton();
        String actualEmailId=account.getUserName();
        String expectedEmailId=data.get(3);
        Assert.assertEquals(actualEmailId,expectedEmailId,"Your Attempt to Login Has Failed");
    }
    @Test(priority = 3,enabled = true,description = "TestCase_002_Verify Login Page Title")
    public void verifyLoginPageTitle() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> data=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "LoginPage");
        String expectedTitle =data.get(5);
        String actualTitle =login.getLoginPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title doesn't match");
    }

}
