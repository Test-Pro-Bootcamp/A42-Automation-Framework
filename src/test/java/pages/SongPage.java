package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongPage extends BasePage {
    BasePage basePage = new BasePage(getDriver());
    // locators
    @FindBy(css = "table > tr:nth-child(1)")
    private WebElement firstSong;
    @FindBy(css = ".btn-add-to")
    private WebElement addToBtn;
    @FindBy(css = "#songsWrapper section.existing-playlists li:nth-child(5)")
    private WebElement firstPlaylist;
    @FindBy(css = "#sidebar > section.music  li:nth-child(3) > a")
    private WebElement allSongsPage;

    public SongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

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
        actions.doubleClick(basePage.waitUntilClickable(firstSong)).perform();
        return this;
    }
}
