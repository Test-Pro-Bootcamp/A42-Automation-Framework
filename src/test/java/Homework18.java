import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Homework18 extends BaseTest {
    @Test
    //Homework18: Play a song and validate the song is playing
    public void playSong() throws InterruptedException {

        login("lidiia@northins.com", "Lidiia1807@");
        Thread.sleep(2000);

        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();

        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());




    }
}


