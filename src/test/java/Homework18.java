import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    @Test
    //Homework18: Play a song and validate the song is playing
    public void playSong() throws InterruptedException{
        PageFactory.initElements(getDriver(), loginPage);
        loginPage.login("lidiia@northins.com", "Lidiia1807@");
        PageFactory.initElements(getDriver(), homePage);
        homePage.goToAllSongs();
        WebElement firstSong = basePage.getDriver().findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(basePage.getDriver());
        actions.contextClick(firstSong).perform();
        WebElement playBtn = basePage.getDriver().findElement(By.cssSelector(".playback"));
        playBtn.click();
        Thread.sleep(4000);
        basePage.waitUntilVisible(By.cssSelector("[data-testid='sound-bar-play']"));

    }
}


