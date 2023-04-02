import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest{
    @Test
    //Homework # 19 change of the code with "waits-"
    public void deletePlaylist() {
        login("lidiia@northins.com", "Lidiia1807@");

        // click on Playlist
        WebElement playlistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[3]")));
        playlistName.click();
        //delete Playlist
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();
        //click on Ok button
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
        deletePlaylistBtn.click();
        //get message Playlist was deleted
        WebElement getNotificationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        Assert.assertTrue(getNotificationText.isDisplayed());

    }
    @Test
    //Homework16, refactored
    public void Navigation() {
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='hel']")));
        registrationLink.click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

    }
    @Test
    //Homework17,refactored
    public void searchSong() {

        login("lidiia@northins.com", "Lidiia1807@");
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Take my Hand");
        WebElement viewAllSongsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='searchExcerptsWrapper']//section[@class='songs']//h1/button")));
        viewAllSongsButton.click();
        WebElement firstSongResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper .items >tr:nth-of-type(1)>.title")));
        firstSongResult.click();
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//div[@class='song-list-controls']//span[@class='btn-group']/button[@class='btn-add-to']")));
        addToButton.click();
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[5]")));
        playlist.click();
        WebElement getNotificationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        Assert.assertTrue(getNotificationText.isDisplayed());
    }
    @Test
    //Homework18, refactored
    public void playSong() {

        login("lidiia@northins.com", "Lidiia1807@");

       WebElement playSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//article[@data-test='song-card']//span[@class='main']//span[@class='details'][contains(text(),'Ketsa - Beautiful')]")));
        new Actions(driver)
                .doubleClick(playSong)
                .perform();
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());

    }
    

}
