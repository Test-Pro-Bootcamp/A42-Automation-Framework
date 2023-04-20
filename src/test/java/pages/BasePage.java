package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class BasePage {
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public BasePage() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public BasePage(WebDriver givenDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(givenDriver, 15), this);
    }

    public void initBrowser(String url) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getDriver());

        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 15), this);
    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.241:4444";
        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            case "cloud" -> {
                return lambdaTest();
            }
            case "grid-firefox" -> {
                capabilities.setCapability("browserName", "firefox");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            }
            case "grid-safari" -> {
                capabilities.setCapability("browserName", "safari");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            }
            case "grid-chrome" -> {
                capabilities.setCapability("browserName", "chrome");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                return new ChromeDriver(options);
            }
        }
    }

    public void closeBrowser() {
        getDriver().close();
        threadDriver.remove();
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

    public WebElement waitClickRepeat(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitUntilClickable(element).click();
                return element;
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            attempts++;
        }
        return element;
    }

    public WebElement waitUntilClickable(WebElement element) {
        return new WebDriverWait(getDriver(), Duration
                .ofSeconds(3))
                .until(ExpectedConditions
                        .elementToBeClickable(element));
    }
}




