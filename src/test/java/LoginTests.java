import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    // locators
    By logOutBtn = By.cssSelector(".fa.fa-sign-out");
    By submitLoginBtn = By.cssSelector("button[type='submit']");
    By registrationLink = By.cssSelector("a[type = 'submit']");
    By registrationBtn = By.id("button");

    @Test
    public void successfulLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.demoPassword);
        Assert.assertTrue(loginPage.waitUntilVisible(logOutBtn).isDisplayed());
    }

    @Test
    public void wrongPasswordLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.wrongPassword);
        Assert.assertTrue(loginPage.waitUntilVisible(submitLoginBtn).isDisplayed());
    }

    @Test
    public void emptyPasswordLoginTest() {
        loginPage.logIn(loginPage.demoEmail, loginPage.emptyPassword);
        Assert.assertTrue(loginPage.waitUntilVisible(submitLoginBtn).isDisplayed());
    }

    @Test
    public void registrationNavigation() {
        basePage.waitUntilClickable(registrationLink).click();
        Assert.assertTrue(basePage.waitUntilVisible(registrationBtn).isDisplayed());
    }

}
