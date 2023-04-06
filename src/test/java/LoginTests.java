import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void successfulLoginTest() {
        logIn("demo@class.com", "te$t$tudent");

        WebElement logOutButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa.fa-sign-out")));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        logIn("demo@class.com", "te$t$tuden");

        WebElement submitLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        logIn("demo@class.com", "");

        WebElement submitLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

}
