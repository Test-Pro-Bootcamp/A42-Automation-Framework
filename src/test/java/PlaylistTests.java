import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest {

    //locators
//    @FindBy(xpath = "//*[@id='playlists']//li[3]/a[contains(text(), 'Renamed')]")
//    private WebElement renamedPlaylist;
    @FindBy(xpath = "//*[@id='playlists']//li[3]/a[contains(text(), 'New')]")
    private WebElement newPlaylist;

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().removePlaylist();
    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        String oldName = "Renamed Playlist";
        playlistPage.createPlaylistIfMissed().choosePlaylist().changePlaylistName();
        String newName = playlistPage.getPlaylistName();
        Assert.assertEquals(oldName, newName);
    }

    @Test
    public void newPlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylist();

        Assert.assertTrue(newPlaylist.isDisplayed());
    }
}
