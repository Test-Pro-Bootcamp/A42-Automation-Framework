import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        //login
       login("dsalina1984@gmail.com ","Qazxsw123@Qazxsw123@");

        // click all songs button
        WebElement allSongsButton = driver.findElement(By.cssSelector("[href='#!/songs']"));
        Thread.sleep(1000);
        allSongsButton.click();

        // play a song

        WebElement clickable = driver.findElement(By.xpath("//td[contains(text(),'Ketsa - That_s a Beat')]"));
        new Actions(driver)
                .doubleClick(clickable)
                .perform();

        //assert equalizer appeared the song is plaing
        WebElement equalizerButton = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(equalizerButton.isDisplayed());

    }

}


