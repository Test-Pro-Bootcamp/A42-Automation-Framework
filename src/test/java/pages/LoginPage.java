package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    BasePage basePage = new BasePage();
    public String myEmail = "victor.colodzei@testpro.io";
    public String myPassword = "hyqsis-1viQni-nogjyx";
    public String demoEmail = "demo@class.com";
    public String demoPassword = "te$t$tudent";
    public String wrongPassword = "te$t$tuden";
    public String emptyPassword = "";

    // locators
    By passwordField = By.cssSelector("[type='password']");
    By emailField = By.xpath("//input[@type='email']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public LoginPage enterPassword(String password) {
        WebElement passwordInput = basePage.waitUntilClickable(passwordField);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        WebElement emailInput = basePage.waitUntilClickable(emailField);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
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
