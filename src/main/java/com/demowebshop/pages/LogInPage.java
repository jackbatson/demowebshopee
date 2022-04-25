package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LogInPage extends ObjectUtility {
    WebDriver driver;
    /** The Page constructor usage**/
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /** The Page Element usage**/
    private final String loginMenu="li>a[class='ico-login'";
    @FindBy(css=loginMenu) WebElement theLoginMenu;

    private final String userName="Email";
    @FindBy(id=userName) WebElement theUserName;

    private final String password="Password";
    @FindBy(id=password) WebElement thePassword;

    private final String loginButton="div>input[type='submit'";
    @FindBy(css=loginButton) WebElement theLoginButton;



    /** The User Action Method usage **/
    public void enterUserName(String uName){
        page.enterText(theUserName,uName);
    }

    public void enterPassword(String pWord){
        page.enterText(thePassword,pWord);
    }

    public MyAccountPage clickOnLoginButton(){
        page.clickOnElement(theLoginButton);
        return new MyAccountPage(driver);
    }

    public String getLoginPageTitle(){
        String loginTitle=page.getPageTitle(driver);
        return loginTitle;
    }

}
