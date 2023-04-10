package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PlaylistPage extends BasePage {
    BasePage basePage = new BasePage();
    // locators
    By deleteBtn = By.cssSelector(".del");
    By notification = By.cssSelector("div.alertify-logs");
    By okBtn = By.cssSelector("button.ok");
    By firstPlaylist = By.cssSelector("#playlists li:nth-child(3)");
    By inputField = By.cssSelector("[data-testid='inline-playlist-name-input']");
    By plusBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By newPlaylistBtn = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By playlistNameField = By.cssSelector("form.create > input");
    By recentlyPlayedPlaylist = By.cssSelector("#playlists li:nth-child(2)");
    By firstPlaylistLink = By.cssSelector("#playlists li:nth-child(3) > a");

    public PlaylistPage changePlaylistName() {
        // double-click on playlist
        new Actions(basePage.getDriver()).doubleClick(basePage.waitUntilClickable(firstPlaylist)).perform();
        // rename
        new Actions(basePage.getDriver()).click(basePage.waitUntilClickable(inputField)).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).sendKeys("Renamed Playlist").sendKeys(Keys.RETURN).perform();
    return this;
    }

    public PlaylistPage createPlaylist() {
        basePage.waitUntilClickable(plusBtn).click();
        basePage.waitUntilClickable(newPlaylistBtn).click();
        //give a name
        new Actions(basePage.getDriver()).click(basePage.waitUntilClickable(playlistNameField)).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).sendKeys("NewPlaylist").sendKeys(Keys.RETURN).perform();
        return this;
    }

    public boolean isUserPlaylistMissed() {
        try {
            basePage.waitUntilClickable(recentlyPlayedPlaylist).isDisplayed();
            basePage.getDriver().findElement(firstPlaylist).isDisplayed();
        } catch (Exception e) {
            System.out.println("There is no third playlist");
            return true;
        }
        return false;
    }

    public PlaylistPage choosePlaylist() {
        basePage.waitUntilClickable(firstPlaylistLink).click();
        return this;
    }

    public PlaylistPage removePlaylist() {
        basePage.waitUntilClickable(deleteBtn).click();
        try {
            // test if there is a notification that we delete playlist successfully
            Assert.assertTrue(basePage.waitUntilVisible(notification).isDisplayed());
        } catch (Exception e) {
            // click ok button if required
            basePage.waitUntilClickable(okBtn).click();
            // second time test if there is a notification that we delete playlist successfully
            Assert.assertTrue(basePage.waitUntilVisible(notification).isDisplayed());
        }
        return this;
    }

    public PlaylistPage createPlaylistIfMissed() {
        // check if there is at list one playlist created by user
        if (isUserPlaylistMissed()) createPlaylist(); // if no, create one
        return this;
    }
}
