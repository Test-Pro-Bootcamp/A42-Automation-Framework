import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class LoginTests extends BaseTest {
    @Test
    public void successfulLoginTest() {

        setUpEmail("demo@class.com");
        setUpPassword("te$t$tudent");
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickLoginButton();
        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());

    }

    @Test
    public void wrongPasswordLoginTest() {


        setUpEmail("demo@class.com");
        setUpPassword("te$t$tudent");
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickLoginButton();
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {


        setUpEmail("demo@class.com");
        setUpPassword(" ");
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickLoginButton();
        Assert.assertTrue(submitLoginButton.isDisplayed());

    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }
}
