import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;

public class Homework21 extends BaseTest {
    String playlistName = "Homework 21";
    @Test
    public void renamePlaylist() {
       login("lidiia@northins.com", "Lidiia1807@");
        choosePlaylist();
        contextClickPlaylist();
        playlistInput();
        Assert.assertTrue(newNamePlaylistExist());
    }
    public void choosePlaylist(){
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[3]"))).click();

    }
    public void contextClickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[3]")));
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//li[3]"));
        actions.doubleClick(playlistElement).perform();

    }
    public void playlistInput() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Homework 21");
        playlistInputField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify-logs top right']")));
    }
    public boolean newNamePlaylistExist(){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Homework 21']"));
        return playlistElement.isDisplayed();

    }
}





