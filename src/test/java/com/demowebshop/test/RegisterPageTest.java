package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterPageTest extends Base {
    RegisterPage register;
    HomePage home;
    MyAccountPage account;
    ExcelUtility excel=new ExcelUtility();


    @Test(priority = 4,enabled = true,description = "TestCase_01 Registration Verification")
    public void verifyRegister() throws IOException {
        home=new HomePage(driver);
        register=home.clickOnRegisterButton();
        List<String> data=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "RegisterPage");
        register.selectGender(data.get(6));
        register.enterFirstName(data.get(7));
        register.enterLastName(data.get(8));
        RandomDataUtility randomdata=new RandomDataUtility();
        String randomMail=randomdata.getRandomMail();
        register.enterEmail(randomMail);
        System.out.println(randomMail);
        register.enterPassword(data.get(9));
        register.reenterPassword(data.get(10));
        account=register.clickOnRegisterButton();
        String actualEmailId=account.getUserName();
        String expectedEmailId=randomMail;
        Assert.assertEquals(actualEmailId,expectedEmailId,"Your Login Attempt has failed");
    }
    @Test(priority = 5,enabled = true,description = "TestCase_02 Verification of Register Page Title")
    public void verifyLoginPageTitle() throws IOException {
        home=new HomePage(driver);
        register=home.clickOnRegisterButton();
        List<String> data=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "RegisterPage");
        String expectedTitle =data.get(11);
        String actualTitle =register.getRegisterPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title doesn't match");
    }
}
