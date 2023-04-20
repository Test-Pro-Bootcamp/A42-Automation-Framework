package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginStepDefinitions extends BasePage {
    LoginPage loginPage = new LoginPage(getDriver());
    @FindBy(css = ".fa.fa-sign-out")
    private WebElement logOutBtn;
    @Before
    public void openBrowser() throws MalformedURLException {
        String url = "https://bbb.testpro.io/";
        initBrowser(url);
    }

    @Given("I enter email {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I submit")
    public void submit() {
        loginPage.clickLoginButton();
    }

    @Then("I am logged in")
    public void logInAssert() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 10), this);
        Assert.assertTrue(logOutBtn.isDisplayed());
    }

    @After
    public void exitBrowser() {
        closeBrowser();
    }

}
