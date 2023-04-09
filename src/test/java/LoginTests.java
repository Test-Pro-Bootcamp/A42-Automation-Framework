import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error

        loginPage.login("anna.stonaieva@testpro.io", "te$t$tudent");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void successfulLoginTest() {
        PageFactory.initElements(loginPage.getDriver(), loginPage);
        loginPage.enterEmail("anna.stonaieva@testpro.io").enterPassword("te$t$tudent").clickSubmitButton();
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        PageFactory.initElements(loginPage.getDriver(), loginPage);
        loginPage.login("anna.stonaieva@testpro.io", "te$t$tudent");
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }
}
