import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        logIn(myEmail, myPassword);

        // check if there is at list one playlist created by user
        if (!isThereUserPlaylist()) createPlaylist(); // if no, create one

        // go to AllSongs page
        WebElement allSongsPage = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music  li:nth-child(3) > a")));
        allSongsPage.click();

        // choose a song from the list of all songs
        WebElement firstSong = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("table > tr:nth-child(1)")));
        firstSong.click();

        // click on AddTo... button
        WebElement addToBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-add-to")));
        addToBtn.click();

        // choose a user's playlist from context menu
        WebElement usersPlaylists = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#songsWrapper section.existing-playlists li:nth-child(5)")));
        usersPlaylists.click();

        WebElement notification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs")));
        Assert.assertTrue(notification.isDisplayed());
    }
}


