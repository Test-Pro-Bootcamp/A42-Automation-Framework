import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    void deletePlaylist() {
        logIn(myEmail, myPassword);

        // Check if there is at least one  user's playlist
        if (isUserPlaylistMissed()) createPlaylist(); // if no, create one
        choosePlaylist();

        // delete PlayList
        WebElement deletePlaylistBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".del")));
        deletePlaylistBtn.click();

        try {
            // test if there is a notification that we delete playlist successful
            WebElement notification = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs")));
            Assert.assertTrue(notification.isDisplayed());
        } catch (Exception e) {
            // check if confirmation is required and do it
            WebElement okBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
            okBtn.click();

            // second time test if there is a notification that we delete playlist successful
            WebElement notification = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs")));
            Assert.assertTrue(notification.isDisplayed());
        }
    }
}
