import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SongPage;

public class BaseTest {
    public BasePage basePage = new BasePage();
    public LoginPage loginPage;
    public PlaylistPage playlistPage;
    public SongPage songPage;
    String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        basePage.initBrowser(url);
        loginPage = new LoginPage(basePage.getDriver());
        playlistPage = new PlaylistPage(basePage.getDriver());
        songPage = new SongPage(basePage.getDriver());
        PageFactory.initElements(new AjaxElementLocatorFactory(basePage.getDriver(), 5), this);

    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        basePage.closeBrowser();
    }
}