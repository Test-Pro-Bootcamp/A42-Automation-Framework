import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public  class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

//      Login
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

        //        click all songs
        WebElement allSongsBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongsBtn.click();
        WebElement buttonPlayOrResume = driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();

        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
        WebElement equalizer = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Thread.sleep(5000);
        Assert.assertTrue(equalizer.isDisplayed());
        driver.quit();

    }
}