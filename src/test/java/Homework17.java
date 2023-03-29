import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String song = "Ketsa - That_s a Beat";

        // Login
        login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");

        // click all songs button
        WebElement allSongsButton = driver.findElement(By.cssSelector("[href='#!/songs']"));
        Thread.sleep(1000);
        allSongsButton.click();


        // click song
        WebElement songName = driver.findElement(By.xpath("//td[contains(text(),'Ketsa - That_s a Beat')]"));
        songName.click();

        // Add TO button
        WebElement addToButton = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToButton.click();

        // playlist name field + click button save
        WebElement playListNameField = driver.findElement(By.xpath("//section[@id='songsWrapper']//*[contains(@placeholder, 'Playlist name')]"));
        playListNameField.click();
        playListNameField.clear();
        playListNameField.sendKeys("Daria");
        new Actions(driver).keyDown(Keys.ENTER).perform();


        //assert banner appeared
        WebElement successBanner = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());

    }

}
