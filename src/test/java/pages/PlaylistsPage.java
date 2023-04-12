package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlaylistsPage extends BasePage {

    @FindBy(css=".playlist:nth-child(3)")
    private WebElement forthPlaylist;

    @FindBy(css=".playlist:nth-child(4)")
    private WebElement fifthPlaylist;
    @FindBy(css=".songs")
    private WebElement allSongs;

    @FindBy(css = "[data-test='add-to-btn']")
    private WebElement addToBtn;

    @FindBy(css="[data-testid='play-btn']")
    private WebElement playBtn;
    @FindBy(css=".form-save [data-test='new-playlist-name']")
    private List<WebElement> listNameField;
    @FindBy(css=".playback")
    private WebElement playBackBtn;
    @FindBy(css = "[data-testid='pause-btn']")
    private WebElement pauseButton;
    @FindBy(css="input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css="#playlistWrapper .song-item")
    private List<WebElement> songItems;


    public void addSongToPlaylist(){
        WebElement addToBtn = waitUntilVisible(this.addToBtn);
        addToBtn.click();
    }

    public void createNewPlaylistWhileAddingSong(String playlistName){
        listNameField.get(2).click();
        listNameField.get(2).clear();
        listNameField.get(2).sendKeys(playlistName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void clickPlayBtn() {
        Actions action = new Actions(driver);
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return this.pauseButton.isDisplayed();
    }


    public void goToAllSongs() {
        waitUntilClickable(this.allSongs ).click();
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = waitUntilClickable(forthPlaylist);
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = (this.playlistInputField );
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        WebElement playlistElement = waitUntilVisible(forthPlaylist);
        return playlistElement.getText();
    }

    public WebElement getFifthPlayList() {
        return waitUntilVisible(fifthPlaylist);
    }

    public List<WebElement> getSongItems() {
        return songItems;
    }
}
