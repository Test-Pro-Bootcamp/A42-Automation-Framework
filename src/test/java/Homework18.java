import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        logIn(myEmail, myPassword);
        chooseAllSongsPage();

        // double-click on a song
        WebElement firstSong = wait.
                until(ExpectedConditions.elementToBeClickable(By.
                        cssSelector("table > tr:nth-child(1)")));
        new Actions(driver).doubleClick(firstSong).perform();

        // check if song is playing
        WebElement soundBars = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(soundBars.isDisplayed());
    }

}
