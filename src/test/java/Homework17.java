import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest {
    @Test
    public void searchSong() {
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();
        HomePage homePage = new HomePage();

           loginPage.login("lidiia@northins.com", "Lidiia1807@");
           homePage.search("Take my Hand");
           homePage.viewAllSearchResults();
           homePage.clickFirstSearchResult();
           homePage.addToPlaylist();
           homePage.playlistElem();
           homePage.getSuccessBanner();

        }

    }






