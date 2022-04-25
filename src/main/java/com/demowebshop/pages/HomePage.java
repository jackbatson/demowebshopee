package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ObjectUtility {
    WebDriver driver;
    /** The Page constructor usage**/
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /** The Page Elements usage**/
    private final String loginMenu="li>a[class='ico-login'";
    @FindBy(css=loginMenu) WebElement theLoginMenu;

    private final String registerMenu="li>a[class='ico-register']";
    @FindBy(css=registerMenu) WebElement theRegisterMenu;

    /**The User Action Method usage**/

    public String getHomePageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }

    public LogInPage clickOnLoginMenu(){
        page.clickOnElement(theLoginMenu);
        return new LogInPage(driver);
    }
    public RegisterPage clickOnRegisterButton(){
        page.clickOnElement(theRegisterMenu);
        return new RegisterPage(driver);
    }
}
