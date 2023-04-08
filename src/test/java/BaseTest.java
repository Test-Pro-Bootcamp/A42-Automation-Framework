import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

public class BaseTest extends BasePage {
    BasePage basePage = new BasePage();
    String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        basePage.initBrowser(url);
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        basePage.closeBrowser();
    }
}