import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;


public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        //login with valid credentials
        enterEmail(myEmail);
        enterPassword(myPassword);
        clickLoginButton();

        //go to All Songs page
        WebElement allSongs = driver.findElement(By.cssSelector("a.songs"));
        allSongs.click();

        try {
            sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //right-click on a song
        List<WebElement> song = driver.findElements(By.cssSelector("td.title"));
        new Actions(driver)
                .contextClick(song.get(0))
                .perform();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click on play button from context menu
        WebElement playBtn = driver.findElement(By.cssSelector("li.playback"));
        playBtn.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //check if song is playing
        WebElement soundBars = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        Assert.assertTrue(soundBars.isDisplayed());
    }
}
