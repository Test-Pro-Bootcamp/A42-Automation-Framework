import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    @Test
    //Homework # 19 deletePlaylist
    public void deletePlaylist() {
        loginPage.login("lidiia@northins.com", "Lidiia1807@");
        homePage.clickPlaylist();
        homePage.deletePl();
        homePage.okBtnDeletePl();
        homePage.getSuccessBanner();
        Assert.assertTrue(homePage.getSuccessBanner().isDisplayed());

        }

        }


