import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.net.MalformedURLException;

public class BaseTest extends BasePage {
    String url = "https://bbb.testpro.io/";

    @BeforeMethod
    void setUpBrowser() throws MalformedURLException {
        initBrowser(url);
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        closeBrowser();
    }
}