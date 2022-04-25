package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends ObjectUtility {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements usage**/
    private final String genderSelection="//label[contains(@for,'gender')]";
    @FindBy(css=genderSelection) WebElement selectTheGender;

    private final String nameFirst="//input[@id='FirstName']";
    @FindBy(xpath=nameFirst) WebElement firstName;

    private final String nameLast="//input[@id='LastName']";
    @FindBy(xpath=nameLast) WebElement lastName;

    private final String email="//input[@id='Email']";
    @FindBy(xpath=email) WebElement Email;

    private final String password="//input[@id='Password']";
    @FindBy(xpath=password) WebElement Password;

    private final String confirmPassword="//input[@id='ConfirmPassword']";
    @FindBy(xpath=confirmPassword) WebElement ConfirmPassword;

    private final String registerButton="//input[@id='register-button']";
    @FindBy(xpath=registerButton) WebElement RegisterButton;

    /** Usage of User Action Method **/
    public void selectGender(String gender) {
        List<WebElement> options = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase(gender)) {
                options.get(i).click();
            }
        }
    }

    public void enterFirstName(String fName) {
        page.enterText(firstName, fName);
    }

    public void enterLastName(String lName) {
        page.enterText(lastName, lName);
    }

    public void enterEmail(String eMail) { page.enterText(Email, eMail);
    }

    public void enterPassword(String pWord) {
        page.enterText(Password, pWord);
    }

    public void reenterPassword(String rePWord) {
        page.enterText(ConfirmPassword, rePWord);
    }

    public MyAccountPage clickOnRegisterButton() {
        page.clickOnElement(RegisterButton);
        return new MyAccountPage(driver);
    }

    public String getRegisterPageTitle() {
        String registerTheTitle = page.getPageTitle(driver);
        return registerTheTitle;
    }

}
