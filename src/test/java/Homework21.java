import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    void renamePlaylist() {
        logIn(myEmail, myPassword);
        if (isUserPlaylistMissed()) createPlaylist();
        choosePlaylist();

        WebElement firstPlaylist = wait
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("#playlists li:nth-child(3)")));
        new Actions(driver).doubleClick(firstPlaylist).perform();

        WebElement inputField = wait
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("[data-testid='inline-playlist-name-input']")));
        new Actions(driver)
                .click(inputField)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.DELETE)
                .sendKeys("Renamed Playlist")
                .sendKeys(Keys.RETURN)
                .perform();

        WebElement renamedPlaylist = wait
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//*[@id='playlists']//li[3]/a[contains(text(), 'Renamed')]")));
        Assert.assertTrue(renamedPlaylist.isDisplayed());
    }
}
