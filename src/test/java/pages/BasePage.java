package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class BasePage {

    protected WebDriver driver;
    //    protected WebDriverWait wait;
    protected Actions actions;
    protected ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public BasePage() {

    }

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        threadDriver.set(driver);
        actions = new Actions(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void initBrowser(String url) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.241:4444";
        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            }
            case "cloud" -> {
                return lambdaTest();
            }
            case "grid-firefox" -> {
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            }
            case "grid-safari" -> {
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            }
            case "grid-chrome" -> {
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                return driver = new ChromeDriver(options);
            }
        }
    }

    public void closeBrowser() {
        getDriver().quit();
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "victorcolodzei";
        String authkey = "9Au7lmlcwcfFv6Y5RvWnxQFZBWydbhihS3AH1s2OtQtzJkxc3b";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Firefox");
        caps.setCapability("version", "103.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }
}
