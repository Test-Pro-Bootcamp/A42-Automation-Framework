import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    PlaylistPage playlistsPage = new PlaylistPage();
    SongsPage songsPage = new SongsPage();

    @Test
    public void addSongToPlaylist() {

        String song = "Take my Hand";
        PageFactory.initElements(getDriver(), loginPage);
        loginPage.login("demo@class.com", "te$t$tudent");
        PageFactory.initElements(getDriver(), homePage);
        homePage.search(song);
        homePage.viewAllSearchResults();
        homePage.clickFirstSearchResult();
        playlistsPage.addSongToPlaylist();
        playlistsPage.createNewPlaylistWhileAddingSong("A42-QA");
        Assert.assertTrue(homePage.getSuccessBanner().isDisplayed());
    }

    @Test
    public void playSong() {
        PageFactory.initElements(getDriver(), loginPage);
        loginPage.login("demo@class.com", "te$t$tudent");
        songsPage.hoverOverPlayControl();
        songsPage.playSong();
        Assert.assertTrue(songsPage.getPauseButton().isDisplayed());
    }
}
