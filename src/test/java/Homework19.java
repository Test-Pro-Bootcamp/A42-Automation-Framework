import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    private void deletePlaylist() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistButton.click();
    }
}
