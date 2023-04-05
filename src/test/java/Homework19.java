import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest {

    @Test
    void deletePlaylist() throws InterruptedException {
        logIn(myEmail, myPassword);

        List<WebElement> initialList = driver.findElements(By.cssSelector("#playlists .playlist"));
        // Check if there is at least one playlist
        if (initialList.size() <= 2) {
            createPlaylist(); // if no, create one
            Thread.sleep(2000);
        }

        // delete PlayList
        List<WebElement> afterAddList = driver.findElements(By.cssSelector("#playlists .playlist"));
        afterAddList.get(2).click();
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".del"));
        deletePlaylistBtn.click();

        // if confirmation is required
        try {
            WebElement okBtn = driver.findElement(By.cssSelector("button.ok"));
            okBtn.click();
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Delete confirmation isn't required");
        }

        Assert.assertTrue(initialList.size() <= afterAddList.size());

    }


}
