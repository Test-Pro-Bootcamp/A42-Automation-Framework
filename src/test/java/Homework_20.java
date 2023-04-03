import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_20 extends BaseTest{
    @Test
    public void successfulLoginTest() {
        login("demo@class.com", "te$t$tudent");
        WebElement avatar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a .avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        login("demo@class.com", "te$t$tuden");
        WebElement submitLoginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        login("demo@class.com", "");
        WebElement submitLoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        Assert.assertTrue(submitLoginButton.isDisplayed());
    }
    @Test
    public void RegistrationNovigation() {
        WebElement RegistrationButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='hel']")));
        RegistrationButton.click();
        WebElement RegisterButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#button")));
        Assert.assertTrue(RegisterButton.isDisplayed());
    }
    @Test
    public void deletePlayList() {
        login("chernyakma75@gmail.com", "te$t$tudent");
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='playlist playlist']>a")));
        playlist.click();
        WebElement deletePlayListButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        deletePlayListButton.click();
        // WebElement ok = driver.findElement(By.cssSelector("[class='ok']"));
        // ok.click();
        WebElement SuccessShow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        Assert.assertTrue(SuccessShow.isDisplayed());
    }
    @Test
    public void PlaySong() throws InterruptedException {

        login("chernyakma75@gmail.com","te$t$tudent" );

        WebElement hover = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Play or resume']")));
        new Actions(driver)
                .moveToElement(hover)
                .perform();
        //Thread.sleep(5000);
        hover.click();
        WebElement pause=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='pause']")));
        Assert.assertTrue(pause.isDisplayed());
    }

}





