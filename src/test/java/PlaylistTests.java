import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{
    @Test
    public void deletePlayList() {
        login("chernyakma75@gmail.com", "te$t$tudent");
        WebElement playlist = driver.findElement(By.cssSelector("[class='playlist playlist']>a"));
        playlist.click();
        WebElement deletePlayListButton = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlayListButton.click();
       // WebElement ok = driver.findElement(By.cssSelector("[class='ok']"));
       // ok.click();
        WebElement SuccessShow = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(SuccessShow.isDisplayed());



    }
}
