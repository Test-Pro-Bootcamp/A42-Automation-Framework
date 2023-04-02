import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {
        login("demo@class.com","te$t$tudent");
        openPlaylist();
        deletePlaylist();

        WebElement deletedPlaylistMsg = getDeletedPlaylistMsg();
        Assert.assertTrue(deletedPlaylistMsg.isDisplayed());
    }

    //private void login(String email, String password) {
        //email("demo@class.com");
        //password("te$t$tudent");
    //}

    public WebElement getDeletedPlaylistMsg() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    public void openPlaylist() throws InterruptedException {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(5000);
    }

    private void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(2000);
    }
}
