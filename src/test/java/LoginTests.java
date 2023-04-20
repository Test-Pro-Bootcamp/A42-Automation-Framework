import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void successfulLoginTest() {

        loginPage.setUpEmail("demo@class.com");
        loginPage.setUpPassword("te$t$tudent");
        WebElement submitLoginButton = basePage.getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginPage.clickLoginButton();
        WebElement avatar = loginPage.getDriver().findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());

    }

    @Test
    public void wrongPasswordLoginTest() {

        loginPage.setUpEmail("demo@class.com");
        loginPage.setUpPassword("te$t$tudent");
        WebElement submitLoginButton = basePage.getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginPage.clickLoginButton();
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    LoginPage loginPage = new LoginPage();
   /*  @Test
    public void emptyPasswordLoginTest() {


        setUpEmail("demo@class.com");
        setUpPassword(" ");
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickLoginButton();
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }


    */
}
