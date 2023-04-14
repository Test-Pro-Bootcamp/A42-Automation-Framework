import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    // locators
    @FindBy(css = ".fa.fa-sign-out")
    private WebElement logOutBtn;
    @FindBy(css = "button[type='submit']")
    private WebElement submitLoginBtn;
    @FindBy(css = "a[type = 'submit']")
    private WebElement registrationLink;
    @FindBy(id = "button")
    private WebElement registrationBtn;

    @Test
    public void successfulLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.demoPassword);
        Assert.assertTrue(logOutBtn.isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.wrongPassword);
        Assert.assertTrue(submitLoginBtn.isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.emptyPassword);
        Assert.assertTrue(submitLoginBtn.isDisplayed());
    }

    @Test
    public void registrationNavigation() {
        registrationLink.click();
        Assert.assertTrue(registrationBtn.isDisplayed());
    }
}
