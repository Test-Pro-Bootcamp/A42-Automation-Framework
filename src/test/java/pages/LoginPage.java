package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {

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
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage clickLoginButton() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
        submitBtn.click();
        return this;
    }

    public LoginPage logIn(String email, String password) {
        return enterEmail(email).enterPassword(password).clickLoginButton();
    }
}
