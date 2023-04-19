package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions{
    WebDriverWait wait;
    WebDriver driver;
    @Given("I open browser")
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
@And("I open Login Page")
    public void openLoginPage(){
       driver.get("https://bbb.testpro.io");

}
@When("I enter email{string}")
    public void enterEmail(String email){
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys("lidiia@northins.com");
}
@And("I enter password{string}")
    public void enterPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys("Lidiia1807@");
}
@And("I submit")
    public void submit(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();

}
@Then("I am logged in")
  public void userIsLoggedIn(){
     Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a .avatar"))).isDisplayed());
}

}
