package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginStepDefinition extends BasePage {
    @Before
    public void openBrowser() throws MalformedURLException {
        String url = "https://bbb.testpro.io/";
        initBrowser(url);
    }

    @After
    public void exitBrowser() {
        closeBrowser();
    }
    LoginPage loginPage = new LoginPage();


    @When("I enter email {string}")
    public void EnterEmail(String email) {
        loginPage.enterEmail(email);


        }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);

    }

    @And("I submit")
    public void submit() {
        loginPage.clickLoginButton();
    }

    @Then("I am logged in")
    public void isUserLoggedIn() {
        Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
    }
}
