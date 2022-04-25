package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.MyAccountPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyAccountPageTest extends Base {
    MyAccountPage account;

    @Test(priority = 6, enabled = true, description = "TestCase_001_Verify My Account Page")
    public void verifyLogin() throws IOException {
        account=new MyAccountPage(driver);

    }
}
