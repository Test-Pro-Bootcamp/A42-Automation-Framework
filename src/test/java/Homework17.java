import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest {
    @Test
    public void searchSong() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        PageFactory.initElements(getDriver(), loginPage);
           loginPage.login("lidiia@northins.com", "Lidiia1807@");
        PageFactory.initElements(getDriver(), homePage);
           homePage.search("Take my Hand");
           homePage.viewAllSearchResults();
           homePage.clickFirstSearchResult();
           homePage.addToPlaylist();
           homePage.playlistElem();
           homePage.getSuccessBanner();

        }

    }






