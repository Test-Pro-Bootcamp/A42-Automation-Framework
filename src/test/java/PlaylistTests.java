import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    PlaylistPage playlistPage = new PlaylistPage();

    //locators
    By renamedPlaylist = By.xpath("//*[@id='playlists']//li[3]/a[contains(text(), 'Renamed')]");
    By newPlaylist = By.xpath("//*[@id='playlists']//li[3]/a[contains(text(), 'New')]");

    @Test
    void deletePlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().removePlaylist();
    }

    @Test
    void renamePlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().changePlaylistName();
        Assert.assertTrue(basePage.waitUntilVisible(renamedPlaylist).isDisplayed());

    }

    @Test
    void newPlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylist();
        Assert.assertTrue(basePage.waitUntilVisible(newPlaylist).isDisplayed());
    }
}
