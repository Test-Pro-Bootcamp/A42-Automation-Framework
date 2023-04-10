package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class SongPage extends BasePage {
    BasePage basePage = new BasePage();
    // locators
    By firstSong = By.cssSelector("table > tr:nth-child(1)");
    By addToBtn = By.cssSelector(".btn-add-to");
    By firstPlaylist = By.cssSelector("#songsWrapper section.existing-playlists li:nth-child(5)");
    By allSongsPage = By.cssSelector("#sidebar > section.music  li:nth-child(3) > a");

    public SongPage songToPlaylist() {
        // choose a song
        basePage.waitUntilClickable(firstSong).click();
        // click on AddTo... button
        basePage.waitUntilClickable(addToBtn).click();
        // choose a user's playlist from context menu
        basePage.waitUntilClickable(firstPlaylist).click();
        return this;
    }

    public SongPage goToAllSongsPage() {
        basePage.waitUntilClickable(allSongsPage).click();
        return this;
    }

    public SongPage startPlayingSong() {
        // double-click on a song to start playing
        new Actions(basePage.getDriver()).doubleClick(basePage.waitUntilClickable(firstSong)).perform();
        return this;
    }
}
