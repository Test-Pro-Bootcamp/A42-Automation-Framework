import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest {
    @Test
    //Homework # 19 deletePlaylist
    public void deletePlaylist() throws InterruptedException {
        login("lidiia@northins.com", "Lidiia1807@");
        Thread.sleep(2000);
        //click on Playlist
        WebElement playlistName = driver.findElement(By.xpath("//section[@id='playlists']//li[3]"));
        playlistName.click();
        //delete Playlist
        WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePlaylist.click();
        //click on Ok button
         WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("button.ok"));
         deletePlaylistBtn.click();
         //get message Playlist was deleted
        WebElement getNotificationText = driver.findElement(By.cssSelector(".success.show"));
        getNotificationText.getText();
        Assert.assertTrue(getNotificationText.isDisplayed());

            }

        }


