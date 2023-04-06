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

        //go to All Songs page
        WebElement allSongsPage = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music  li:nth-child(3) > a")));
        allSongsPage.click();

        try {
           //right-click on a song
           WebElement firstSong = wait.until(
                   ExpectedConditions.elementToBeClickable(By.cssSelector("table > tr:nth-child(1)")));
           new Actions(driver).contextClick(firstSong).perform();

       } catch (Exception e) {
           allSongsPage.click();
           System.out.println("Second click on AllSongs page");

           //right-click on a song
           WebElement firstSong = wait.until(
                   ExpectedConditions.elementToBeClickable(By.cssSelector("table > tr:nth-child(1)")));
           new Actions(driver).contextClick(firstSong).perform();
       }

        //click on play button from context menu
        WebElement playBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("li.playback")));
        playBtn.click();

        //check if song is playing
        WebElement soundBars = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(soundBars.isDisplayed());
    }
}
