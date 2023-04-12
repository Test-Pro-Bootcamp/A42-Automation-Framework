import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage(basePage.getDriver());

    // locators
    @FindBy(css = ".fa.fa-sign-out")
    private WebElement logOutBtn;
    @FindBy(css = "button[type='submit']")
    private WebElement submitLoginBtn;
    @FindBy(css = "a[type = 'submit']")
    private WebElement registrationLink;
    @FindBy(id = "button")
    private WebElement registrationBtn;

    public LoginTests(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public LoginTests successfulLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.demoPassword);
        Assert.assertTrue(basePage.waitUntilVisible(logOutBtn).isDisplayed());
        return this;
    }

    @Test
    public LoginTests wrongPasswordLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.wrongPassword);
        Assert.assertTrue(basePage.waitUntilVisible(submitLoginBtn).isDisplayed());
        return this;
    }

    @Test
    public LoginTests emptyPasswordLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.emptyPassword);
        Assert.assertTrue(basePage.waitUntilVisible(submitLoginBtn).isDisplayed());
        return this;
    }

    @Test
    public LoginTests registrationNavigation() {
        basePage.waitUntilClickable(registrationLink).click();
        Assert.assertTrue(basePage.waitUntilVisible(registrationBtn).isDisplayed());
        return this;
    }

}
