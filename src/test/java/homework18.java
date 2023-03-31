import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;


public class homework18 extends BaseTest {
    @Test

    public void playSong() {

        login("demo@class.com", "te$t$tudent");
        //playSong();

        Assert.assertTrue(isDisplayedPlayingSong());
    }


    public void login(String email, String password) {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
    public void btnPlaySong() throws InterruptedException {
        WebElement buttonPlaySong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        Thread.sleep(5000);
        buttonPlaySong.click();
    }

    public boolean isDisplayedPlayingSong() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPlaying.isDisplayed();
    }



}
