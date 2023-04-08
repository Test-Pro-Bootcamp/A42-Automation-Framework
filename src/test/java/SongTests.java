import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongPage;

public class SongTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    SongPage songPage = new SongPage();
    PlaylistPage playlistPage = new PlaylistPage();

    // locators
    By notification = By.cssSelector("div.alertify-logs");
    By soundBarsIcon = By.cssSelector("img[alt='Sound bars']");

    @Test
    public void addSongToPlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed();
        songPage.goToAllSongsPage();
        songPage.songToPlaylist();
        Assert.assertTrue(basePage.waitUntilVisible(notification).isDisplayed());
    }

    @Test
    public void playSong() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        songPage.goToAllSongsPage();
        songPage.startPlayingSong();
        Assert.assertTrue(basePage.waitUntilVisible(soundBarsIcon).isDisplayed());
    }
}
