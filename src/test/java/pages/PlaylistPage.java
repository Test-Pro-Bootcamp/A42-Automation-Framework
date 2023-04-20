package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PlaylistPage extends BasePage {

    // locators
    @FindBy(css = ".del")
    private WebElement deleteBtn;
    @FindBy(css = "div.alertify-logs")
    private WebElement notification;
    @FindBy(css = "button.ok")
    private WebElement okBtn;
    @FindBy(css = "#playlists li:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[data-testid='inline-playlist-name-input']")
    private WebElement inputField;
    @FindBy(css = "i.fa-plus-circle")
    private WebElement plusBtn;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistBtn;
    @FindBy(css = "form.create > input")
    private WebElement playlistNameField;
    @FindBy(css = "#playlists li:nth-child(2)")
    private WebElement recentlyPlayedPlaylist;
    @FindBy(css = "#playlists li:nth-child(3) > a")
    private WebElement firstPlaylistLink;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public PlaylistPage changePlaylistName() {
        // double-click on playlist
        new Actions(getDriver())
                .doubleClick((firstPlaylist))
                .perform();
        // rename
        new Actions(getDriver())
                .click((inputField))
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.DELETE)
                .sendKeys("Renamed Playlist")
                .sendKeys(Keys.RETURN)
                .perform();
        return this;
    }

    public String getPlaylistName() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return firstPlaylist.getText();
    }

    public PlaylistPage createPlaylist() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        plusBtn.click();
        newPlaylistBtn.click();
        //give a name
        new Actions(getDriver())
                .click(playlistNameField)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.DELETE)
                .sendKeys("NewPlaylist")
                .sendKeys(Keys.RETURN)
                .perform();
        return this;
    }

    public boolean isUserPlaylistMissed() {
        try {
            recentlyPlayedPlaylist.isDisplayed();
            firstPlaylist.isDisplayed();
        } catch (Exception e) {
            System.out.println("There is no third playlist");
            return true;
        }
        return false;
    }

    public PlaylistPage choosePlaylist() {
        firstPlaylistLink.click();
        return this;
    }

    public PlaylistPage removePlaylist() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        deleteBtn.click();
        try {
            // test if there is a notification that we delete playlist successfully
            Assert.assertTrue(notification.isDisplayed());
        } catch (Exception e) {
            // click ok button if required
            okBtn.click();
            // second time test if there is a notification that we delete playlist successfully
            Assert.assertTrue(notification.isDisplayed());
        }
        return this;
    }

    public PlaylistPage createPlaylistIfMissed() {
        // check if there is at list one playlist created by user
        if (isUserPlaylistMissed()) createPlaylist(); // if no, create one
        return this;
    }
}
