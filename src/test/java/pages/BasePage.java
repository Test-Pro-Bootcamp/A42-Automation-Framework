package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage() {

    }

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initBrowser(String url) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitUntilClickable(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(webElement));

    }

    public WebElement waitUntilVisible(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(webElement));
    }
}
