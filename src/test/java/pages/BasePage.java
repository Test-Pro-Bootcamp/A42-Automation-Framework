package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
//    WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public void initBrowser(String url) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(url);

//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitUntilClickable(By locator) {
//        return wait.until(ExpectedConditions.elementToBeClickable(locator));
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(locator));

    }

    public WebElement waitUntilVisible(By locator) {
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
