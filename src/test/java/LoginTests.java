import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    // locators
    @FindBy(css = ".fa.fa-sign-out")
    WebElement logOutBtn;
    @FindBy(css = "button[type='submit']")
    WebElement submitLoginBtn;
    @FindBy(css = "a[type = 'submit']")
    WebElement registrationLink;
    @FindBy(id = "button")
    WebElement registrationBtn;


    @Test
    public void successfulLoginTest() throws InterruptedException {
        PageFactory.initElements(getDriver(), this);
        loginPage.logIn(loginPage.demoEmail, loginPage.demoPassword);
        Thread.sleep(4000);
        Assert.assertTrue(logOutBtn.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() throws InterruptedException {
        PageFactory.initElements(getDriver(), this);
        loginPage.logIn(loginPage.demoEmail, loginPage.wrongPassword);
        Thread.sleep(4000);
        Assert.assertTrue(submitLoginBtn.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() throws InterruptedException {
        PageFactory.initElements(getDriver(), this);
        loginPage.logIn(loginPage.demoEmail, loginPage.emptyPassword);
        Thread.sleep(4000);
        Assert.assertTrue(submitLoginBtn.isDisplayed());
    }

    @Test
    public void registrationNavigation() throws InterruptedException {
        PageFactory.initElements(getDriver(), this);
        registrationLink.click();
        Thread.sleep(4000);
        Assert.assertTrue(registrationBtn.isDisplayed());
    }

}
