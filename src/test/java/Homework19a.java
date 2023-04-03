import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework19a extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        //login
        login("dsalina1984@gmail.com ","Qazxsw123@Qazxsw123@");

        // navigate playlist + right click mouse

        WebElement playList = driver.findElement(By.cssSelector("[href='#!/playlist/51792']"));
        new Actions(driver)
                .contextClick(playList)
                .perform();

        //  right- click playList button

        WebElement rightClickPlayList = driver.findElement(By.cssSelector("[href='#!/playlist/51792']"));
        new Actions(driver)
                .contextClick(rightClickPlayList)
                .perform();

        // navigate delete button

        WebElement deleteButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-51792']"));
        new Actions(driver)
                .clickAndHold(deleteButton)
                .perform();

        //  click button delete

        WebElement clickable = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-51792']"));
        new Actions(driver)
                .click(clickable)
                .perform();
        //Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='cancel']")));


        // navigate button cancel

         WebElement navigateButtonCancel = driver.findElement(By.cssSelector("[class='cancel']"));
        new Actions(driver)
        .clickAndHold(navigateButtonCancel)
         .perform();


        //click button cancel
        WebElement buttonCancel = driver.findElement(By.cssSelector("[class='cancel']"));
        new Actions(driver)
         .clickAndHold(buttonCancel)
         .perform();

        // assert i see playlist Di
        WebElement playListDiShown = driver.findElement(By.cssSelector("[href='#!/playlist/51792']"));
        Assert.assertTrue(playListDiShown.isDisplayed());


    }


}


