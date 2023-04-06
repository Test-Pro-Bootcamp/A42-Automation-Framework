import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    String myEmail = "victor.colodzei@testpro.io";
    String myPassword = "hyqsis-1viQni-nogjyx";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    static void setUpBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    static void tearDown() {

        driver.quit();
    }

    protected void enterPassword(String password) {
        WebElement passwordInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected void enterEmail(String email) {
        // WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected void clickLoginButton() {
        WebElement submitLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLoginButton.click();
    }

    protected void logIn(String email, String password) {

        //login with valid credentials
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    protected void createPlaylist() {

        WebElement createPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        createPlaylistBtn.click();

        WebElement newPlaylistOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylistOption.click();

        WebElement newPlaylistField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form.create > input")));
        newPlaylistField.click();
        newPlaylistField.clear();
        newPlaylistField.sendKeys("NewPlaylist");
        newPlaylistField.sendKeys(Keys.RETURN);
    }

    boolean isThereUserPlaylist() {

        try {
            WebElement isSecondPlaylist = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists li:nth-child(2)")));
            WebElement isThirdPlaylist = driver.findElement(By.cssSelector("#playlists li:nth-child(3)"));
        } catch (Exception e) {
            System.out.println("There is no third playlist");
            return false;
        }
        return true;
    }
}