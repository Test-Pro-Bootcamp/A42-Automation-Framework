import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

public class BaseTest extends BasePage {
    BasePage basePage = new BasePage(getDriver());
    String url = "https://bbb.testpro.io/";

    public BaseTest(WebDriver givenDriver) {
        super(givenDriver);
    }

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