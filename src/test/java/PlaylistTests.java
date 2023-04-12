import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    PlaylistPage playlistPage = new PlaylistPage(getDriver());

    //locators
    @FindBy(xpath = "//*[@id='playlists']//li[3]/a[contains(text(), 'Renamed')]")
    private WebElement renamedPlaylist;
    @FindBy(xpath = "//*[@id='playlists']//li[3]/a[contains(text(), 'New')]")
    private WebElement newPlaylist;

    public PlaylistTests(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public PlaylistTests deletePlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().removePlaylist();
        return this;
    }

    @Test
    public PlaylistTests renamePlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().changePlaylistName();
        Assert.assertTrue(basePage.waitUntilVisible(renamedPlaylist).isDisplayed());
        return this;
    }

    @Test
    public PlaylistTests newPlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylist();
        Assert.assertTrue(basePage.waitUntilVisible(newPlaylist).isDisplayed());
        return this;
    }
}
