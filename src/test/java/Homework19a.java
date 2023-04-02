import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework19a extends BaseTest {
    @Test
    public void deletePlaylist() {
        //login
        login("dsalina1984@gmail.com ","Qazxsw123@Qazxsw123@");

        // navigate playlist + right click mouse

        WebElement playList = driver.findElement(By.cssSelector("[href='#!/playlist/51567']"));
        new Actions(driver)
                .contextClick(playList)
                .perform();

        //  right- click playList button

        WebElement rightClickPlayList = driver.findElement(By.cssSelector("[href='#!/playlist/51567']"));
        new Actions(driver)
                .contextClick(rightClickPlayList)
                .perform();

        // navigate delete button

        WebElement deleteButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-51567']"));
        new Actions(driver)
                .clickAndHold(deleteButton)
                .perform();

        // right click button delete

        WebElement rightClickButtonDelete = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-51567']"));
        new Actions(driver)
                .contextClick(rightClickButtonDelete)
                .perform();

        // add click delete button



        // navigate button ok

         WebElement navigateButtonOk = driver.findElement(By.cssSelector("[class='ok']"));
        new Actions(driver)
        .clickAndHold(navigateButtonOk)
         .perform();


        //click button ok
        //WebElement buttonOK = driver.findElement(By.cssSelector("[class='ok']"));
        //new Actions(driver)
        // .clickAndHold(buttonOK)
        // .perform();

        // assert playlist deleted

    }


}


