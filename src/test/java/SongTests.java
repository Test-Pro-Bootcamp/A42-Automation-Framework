import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongPage;

public class SongTests extends BaseTest {
    LoginPage loginPage = new LoginPage(basePage.getDriver());
    SongPage songPage = new SongPage(basePage.getDriver());
    PlaylistPage playlistPage = new PlaylistPage(basePage.getDriver());

    // locators
    @FindBy(css = "div.alertify-logs")
    private WebElement notification;
    @FindBy(css = "img[alt='Sound bars']")
    private WebElement soundBarsIcon;

    public SongTests(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public SongTests addSongToPlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed();
        songPage.goToAllSongsPage().songToPlaylist();
        Assert.assertTrue(basePage.waitUntilVisible(notification).isDisplayed());
        return this;
    }

    @Test
    public SongTests playSong() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        songPage.goToAllSongsPage().startPlayingSong();
        Assert.assertTrue(basePage.waitUntilVisible(soundBarsIcon).isDisplayed());
        return this;
    }
}
