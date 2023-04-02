import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest{
    @Test
    public void addSongToPlaylist()throws InterruptedException {
        login("chernyakma75@gmail.com", "te$t$tudent");

        WebElement SearchField= driver.findElement(By.cssSelector("[type='search']"));
        SearchField.click();
        SearchField.clear();
        SearchField.sendKeys("Dark days");

        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();

        WebElement FirstSongButton = driver.findElement(By.cssSelector("#songResultsWrapper .items > tr:nth-of-type(1) > .title"));
        FirstSongButton.click();

        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();

        WebElement ChoosePlaylistButton = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(),'P1')] "));
        ChoosePlaylistButton.click();

        WebElement Notification = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(Notification.isDisplayed());}
    }