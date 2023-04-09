import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {

        String playlistName = "Homework-22";
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        PageFactory.initElements(getDriver(), loginPage);
        loginPage.login("lidiia@northins.com", "Lidiia1807@");
        PageFactory.initElements(getDriver(), homePage);
        homePage.doubleClickChoosePlaylist();
        homePage.enterPlaylistName(playlistName);
        String newName = homePage.getPlaylistName();
        Assert.assertEquals(playlistName, newName);
    }
}








