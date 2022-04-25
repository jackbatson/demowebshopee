package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;
    /** The Page constructor usage**/
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /** The Page Elements usage**/
    private final String theAccount="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath= theAccount) WebElement accountPage;

    /**The User Action Method usage**/
    public String getUserName(){
        String emailId=page.getElementText(accountPage);
        return emailId;
    }


}
