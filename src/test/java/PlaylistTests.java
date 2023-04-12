import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {

    //locators
    @FindBy(xpath = "//*[@id='playlists']//li[3]/a[contains(text(), 'Renamed')]")
    private WebElement renamedPlaylist;
    @FindBy(xpath = "//*[@id='playlists']//li[3]/a[contains(text(), 'New')]")
    private WebElement newPlaylist;


    @Test
    public void deletePlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().removePlaylist();
    }

    @Test
    public void renamePlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylistIfMissed().choosePlaylist().changePlaylistName();
        Assert.assertTrue(basePage.waitUntilVisible(renamedPlaylist).isDisplayed());
    }

    @Test
    public void newPlaylist() {
        loginPage.logIn(loginPage.myEmail, loginPage.myPassword);
        playlistPage.createPlaylist();
        Assert.assertTrue(basePage.waitUntilVisible(newPlaylist).isDisplayed());
    }
}
