import pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class BaseTest {
    private final BasePage basePage = new BasePage();
    public String url = "https://bbb.testpro.io/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        basePage.initBrowser(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        basePage.closeBrowser();
    }

    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }

}

