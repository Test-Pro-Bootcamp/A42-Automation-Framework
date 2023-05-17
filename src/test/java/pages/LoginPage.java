package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage extends BasePage{

    // Locators
    By passwordField = By.cssSelector("[type='password']");
    By emailField = By.xpath("//input[@type='email']");
    By loginBtn = By.cssSelector("button[type='submit']");
    By displayedAvatar = By.cssSelector("a .avatar");
    By displayedForm = By.cssSelector("[data-testid='login-form']");

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
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
   public void clickBTnPlus(){
       WebElement buttonAddPlayL = driver.findElement(By.xpath("//section[@id='playlists']//i[@role='button'] "));
       buttonAddPlayL.click();
   }
   //New Play List
   public void navigateNPLBtn(){
       WebElement btnNewPL = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
       btnNewPL.click();
   }
   public void clickInpField(){
       WebElement inpFieldNPL = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name'] "));
       inpFieldNPL.click();
       inpFieldNPL.clear();
       inpFieldNPL.sendKeys("Queen1");
       new Actions(driver).keyDown(Keys.ENTER).perform();
   }
   public boolean playListIsDisplayed(){
       WebElement newPList = driver.findElement(By.xpath("//section[@id='playlists']/ul//a[@href='#!/playlist/57229']"));
       Assert.assertTrue(newPList.isDisplayed());
        return true;

   }
}





