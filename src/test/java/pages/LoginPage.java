package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public static LoginPage LoginPage() {
        return new LoginPage();
    }

    // Locators
    @FindBy(css = "[type='password']")
    WebElement passwordInput;

    //By passwordField = By.cssSelector("[type='password']");


    By emailField = By.xpath("//input[@type='email']");
    By loginBtn = By.cssSelector("button[type='submit']");
    By displayedAvatar = By.cssSelector("a .avatar");
    By displayedForm = By.cssSelector("[data-testid='login-form']");

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

    }

    public LoginPage enterPassword(String password) {
        //WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;

    }


    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickLoginButton() {
        WebElement submitLoginButton = driver.findElement(loginBtn);
        submitLoginButton.click();
    }
    public boolean isDisplayedAvatar (){
        WebElement avatar = driver.findElement(displayedAvatar);
        return avatar.isDisplayed();
    }
    public boolean isDisplayedForm (){
        WebElement form = driver.findElement(displayedForm);
        return form.isDisplayed();
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}



