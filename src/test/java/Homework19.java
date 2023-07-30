import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework19 extends BaseTest{

    @Test
    public void DeletePlaylist() throws InterruptedException{

        // Login
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--kiosk");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String url = "https://qa.koel.app/";
        driver.get(url);

        // email
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("varjan80@mail.ru");

        // password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        // login button
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();

        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());

        // choose playlist
        WebElement choosePlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));

        Actions actions = new Actions(driver);
        actions.contextClick(choosePlaylist).perform();


        // delete playlist
        WebElement deletePlayList = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[2]"));
        deletePlayList.click();


        // show notification
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        notification.getText();
        Thread.sleep(5000);
        driver.quit();

    }
    }

