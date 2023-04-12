package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    BasePage basePage = new BasePage(getDriver());
    public String myEmail = "victor.colodzei@testpro.io";
    public String myPassword = "hyqsis-1viQni-nogjyx";
    public String demoEmail = "demo@class.com";
    public String demoPassword = "te$t$tudent";
    public String wrongPassword = "te$t$tuden";
    public String emptyPassword = "";

    // locators
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage enterPassword(String password) {
        basePage.waitUntilClickable(passwordField);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        basePage.waitUntilClickable(emailField);
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage clickLoginButton() {
        basePage.waitUntilClickable(submitBtn).click();
        return this;
    }

    public LoginPage logIn(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return this;
    }
}
