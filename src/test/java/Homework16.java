import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {

        WebElement registrationLink = driver.findElement(By.cssSelector("a[type = 'submit']"));
        registrationLink.click();

        WebElement registrationButton = driver.findElement(By.id("button"));
        Assert.assertTrue(registrationButton.isDisplayed());

    }
}
