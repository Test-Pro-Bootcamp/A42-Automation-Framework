package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SongPage extends BasePage {
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
        waitClickRepeat(firstSong);
        // click on AddTo... button
        waitClickRepeat(addToBtn);
        // choose a user's playlist from context menu
        waitClickRepeat(firstPlaylist);
        return this;
    }

    public SongPage goToAllSongsPage() {
        waitClickRepeat(allSongsPage);
        return this;
    }

    public SongPage startPlayingSong() {
        // double-click on a song to start playing
        new Actions(getDriver()).doubleClick(waitClickRepeat(firstSong)).perform();
        return this;
    }
}
