import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

public class BaseTest {
    protected final BasePage basePage = new BasePage();
    public String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
         //static WebDriver driver;
    @BeforeMethod
    public void SetUpBrowser(){
        //      Added ChromeOptions argument below to fix websocket error
        BasePage.initBrowser();
        //Actions actions;
        //actions = new Actions(driver);
        //Actions actions;
        //actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {

        BasePage.closeBrowser();
    }

}