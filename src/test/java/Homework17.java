import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        enterEmail(myEmail);
        enterPassword(myPassword);
        clickLoginButton();

        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs']"));
        allSongs.click();

        WebElement song = driver.findElement(By.xpath("//tr[1]/td[2]"));
        song.click();

        WebElement addTo = driver.findElement(By.cssSelector(".btn-add-to"));
        addTo.click();

        WebElement toMyPlaylist = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[contains(text(),'MyPlaylist')]"));
        toMyPlaylist.click();

        WebElement myPlaylist = driver.findElement(By.cssSelector("a.active"));
        myPlaylist.click();

        WebElement addedSong = driver.findElement(By.xpath("//tr[1]/td[2]"));
        Assert.assertTrue(addedSong.isDisplayed());
    }
}
