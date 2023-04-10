package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickLoginButton() {
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
    }
    public boolean isDisplayedAvatar (){
        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        return avatar.isDisplayed();
    }
    public boolean isDisplayedForm (){
        WebElement form = driver.findElement(By.cssSelector("[data-testid='login-form']"));
        return form.isDisplayed();
    }
}

