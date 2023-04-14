import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongTests extends BaseTest {

    // locators
    @FindBy(css = "div.alertify-logs")
    private WebElement notification;
    @FindBy(css = "img[alt='Sound bars']")
    private WebElement soundBarsIcon;

    @Test
    public void addSongToPlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed();
        songPage.goToAllSongsPage().songToPlaylist();
        Assert.assertTrue(notification.isDisplayed());
    }

    @Test
    public void playSong() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        songPage.goToAllSongsPage().startPlayingSong();
        Assert.assertTrue(soundBarsIcon.isDisplayed());
    }
}
