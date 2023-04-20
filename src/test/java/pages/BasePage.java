package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL= new ThreadLocal<>();
    static WebDriver driver;
    WebDriverWait wait;
    public static WebDriver getThreadLocal(){return THREAD_LOCAL.get();}
    public static void closeBrowser() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
    //    driver.quit();
  //  }

  /*  public void initBrowser(String url) throws MalformedURLException {
      //  ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--disable-notifications");
      //  options.addArguments("--remote-allow-origins=*");
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(url);

    }*/

        public void initBrowser(@Optional String url) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser("browser"));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getThreadLocal().get(url);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

    }
    public WebElement waitUntilVisible(By element) {
       //return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return new WebDriverWait(THREAD_LOCAL.get(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public WebElement waitUntilClickable(By element){
       // return wait.until(ExpectedConditions.elementToBeClickable(element));
        return new WebDriverWait(THREAD_LOCAL.get(), Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebDriver getDriver(){
        return THREAD_LOCAL.get();
    }



    public WebDriver pickBrowser(String browser)throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.121:4444";

    switch (browser){
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();

        case "grid-firefox":
            capabilities.setCapability("browserName", "firefox");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
        case "grid-chrome":
            capabilities.setCapability("browserName", "chrome");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
       // case "cloud":
        default:
            return lambdaTest();

    /*    default:
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            return driver = new ChromeDriver(options);*/
    }
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "chernyakma75";
        String authkey = "Sk9qFDYVvYhQA6Ohym8fv4sqa5lBRRfpx1MuFHjcqqQtfQcIwd";
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

