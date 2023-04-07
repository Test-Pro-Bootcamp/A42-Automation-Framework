import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        // double click
        String playlistName = "Homework-22";
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();
        HomePage homePage = new HomePage();

        loginPage.login("lidiia@northins.com", "Lidiia1807@");
        homePage.doubleClickChoosePlaylist();
        homePage.enterPlaylistName(playlistName);
        String newName = homePage.getPlaylistName();
        Assert.assertEquals(playlistName, newName);
    }
}








