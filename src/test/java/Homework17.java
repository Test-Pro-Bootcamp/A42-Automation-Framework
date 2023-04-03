
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void searchSong() throws InterruptedException {

           login("lidiia@northins.com", "Lidiia1807@");
            Thread.sleep(2000);
            WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
            searchInput.click();
            searchInput.clear();
            searchInput.sendKeys("Take my Hand");
            WebElement viewAllSongsButton = driver.findElement(By.xpath("//section[@id='searchExcerptsWrapper']//section[@class='songs']//h1/button"));
            viewAllSongsButton.click();
            WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper .items >tr:nth-of-type(1)>.title"));
            firstSongResult.click();
            WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div[@class='song-list-controls']//span[@class='btn-group']/button[@class='btn-add-to']"));
            addToButton.click();

            WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[5]"));
            playlist.click();

            WebElement getNotificationText = driver.findElement(By.cssSelector(".success.show"));
            getNotificationText.getText();
            Assert.assertTrue(getNotificationText.isDisplayed());
        }

    }






