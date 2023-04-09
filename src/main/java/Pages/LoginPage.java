package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // locators:
    By passwordField = By.cssSelector("[type='password']");

    public void login(String email, String password) {

        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    protected void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailInput = waitUntilVisible(By.xpath("//input[@type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected void clickLoginButton() {
        WebElement submitLoginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
    }
}

