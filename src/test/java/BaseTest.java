import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongPage;

import java.net.MalformedURLException;

public class BaseTest {
    public BasePage basePage = new BasePage();
    public LoginPage loginPage;
    public PlaylistPage playlistPage;
    public SongPage songPage;
    String url = "https://bbb.testpro.io/";


    @BeforeMethod
    void setUpBrowser() throws MalformedURLException {
        basePage.initBrowser(url);

        loginPage = new LoginPage(basePage.getDriver());
        playlistPage = new PlaylistPage(basePage.getDriver());
        songPage = new SongPage(basePage.getDriver());

        PageFactory.initElements(new AjaxElementLocatorFactory(basePage.getDriver(), 10), this);
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        basePage.closeBrowser();
    }
}