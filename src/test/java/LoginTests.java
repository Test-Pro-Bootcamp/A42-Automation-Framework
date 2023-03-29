import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void successfulLoginTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginButton();

        WebElement logOutButton = driver.findElement(By.cssSelector(".fa.fa-sign-out"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tuden");
        clickLoginButton();

        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        enterEmail("demo@class.com");
        enterPassword("");
        clickLoginButton();

        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

}
