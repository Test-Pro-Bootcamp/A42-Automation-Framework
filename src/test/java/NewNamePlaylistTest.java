import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewNamePlaylistTest extends BaseTest{

    @Test
            public void renamePlayList (){
        // Login
        login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");

        // navigate playList
        WebElement navigatePlayList = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();

        //double click left botton mouse
        WebElement leftClickPlaylistButton = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .doubleClick(leftClickPlaylistButton)
                .perform();

        // Click and release playList
        WebElement clickReleasePlayListButton = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .click(clickReleasePlayListButton)
                .perform();

        // field add new playListName
            WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
            playlistInputField.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
            playlistInputField.sendKeys("Sasha");
            playlistInputField.sendKeys(Keys.ENTER);

            // Assert playlist renamed
          Assert.assertEquals(navigatePlayList.getText(),"Sasha");

    }
}


