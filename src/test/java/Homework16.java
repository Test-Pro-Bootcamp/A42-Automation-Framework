import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        WebElement registrationLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a[type = 'submit']")));
        registrationLink.click();

        WebElement registrationButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("button")));
        Assert.assertTrue(registrationButton.isDisplayed());
    }
}
