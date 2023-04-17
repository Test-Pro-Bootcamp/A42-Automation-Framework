
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;



public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    @Test
    public void successfulLoginTest()  {
        PageFactory.initElements(basePage.getDriver(),loginPage);
        LoginPage loginPage = new LoginPage();  //это мы создаем объект!!!!
        loginPage.login("dsalina1984@gmail.com","Qazxsw123@Qazxsw123@");
        Assert.assertTrue(loginPage.isDisplayedAvatar());

    }

    @Test
    public void wrongPasswordLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("dsalina1984@gmail.com", "");
        //Assert.assertTrue((loginPage.isDisplayedForm()));
        Assert.assertEquals(loginPage.getUrl(),url);

    }
    /*

    @Test
    public void emptyPasswordLoginTest(){

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        // email
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        // password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("");
        // login button
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
        Assert.assertTrue(submitLoginButton.isDisplayed());
        driver.quit();
    }
    */
}