package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public static LoginPage loginPage(){

        return new LoginPage();
    }
        // locators
        //@FindBy(css= ("[type='password']"))
        //private WebElement passwordInput;
        By passwordField = By.cssSelector("[type='password']");
        //@FindBy(xpath=("//input[@type='email']"))
        //private WebElement emailInput;
        By emailField = By.xpath("//input[@type='email']");

        //@FindBy(css=("button[type='submit']"))
        //WebElement submitLoginButton;
        By submitBtn = By.cssSelector("button[type='submit']");


        public void login(String email, String password) {
            enterEmail(email);
            enterPassword(password);
            clickLoginButton();
        }

        public LoginPage enterPassword(String password) {
           //WebElement passwordInput = waitUntilVisible(passwordField);
            WebElement passwordInput = getDriver().findElement(passwordField);
            passwordInput.click();
            passwordInput.clear();
            passwordInput.sendKeys(password);
            return this;
        }

        public LoginPage enterEmail(String email) {
            //WebElement emailInput = waitUntilVisible(emailField);
            WebElement emailInput = getDriver().findElement(emailField);
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys(email);
            return this;
        }

        public LoginPage clickLoginButton() {
            //WebElement submitLoginButton = waitUntilVisible(submitBtn);
            WebElement submitLoginButton = getDriver().findElement(submitBtn);
            submitLoginButton.click();
            return this;
        }

        public WebElement getSubmitLoginButton(){

            return waitUntilVisible(submitBtn);
        }
    }
