package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PlayListPage extends BasePage {
    LoginPage loginPage = new LoginPage();

    // Created PlayList
    public void navigatePlayListBtn() {
        WebElement createPlayListButton = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        new Actions(driver)
                .contextClick(createPlayListButton)
                .perform();
    }


    public void clickPlayListBtn() {
        WebElement clickPlayListButton = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        new Actions(driver)
                .click(clickPlayListButton)
                .perform();
    }

    public void navigateNewPlaylistBtn() {
        WebElement newPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple'] "));
        new Actions(driver)
                .contextClick(newPlayListButton)
                .perform();
    }
    public void clickNewPlayListBtn() {
        WebElement clickNewPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple'] "));
        new Actions(driver)
                .click(clickNewPlayListButton)
                .perform();
    }
    public void navigateField() {
        WebElement navigateFieldCreatePlayList = driver.findElement(By.xpath("//form[@name='create-simple-playlist-form']//input"));
        new Actions(driver)
                .contextClick(navigateFieldCreatePlayList)
                .perform();
    }
    public void newNamePlayList() {
        WebElement addplayListNameField = driver.findElement(By.xpath("//form[@name='create-simple-playlist-form']//input"));
        addplayListNameField.click();
        addplayListNameField.clear();
        addplayListNameField.sendKeys("Di1");
        new Actions(driver).keyDown(Keys.ENTER).perform();
    }
    public void assertNewPlayListAppeared() throws InterruptedException {
        WebElement playListCreated = driver.findElement(By.cssSelector(".success.show"));
        Thread.sleep(1000);
        Assert.assertTrue(playListCreated.isDisplayed());
    }

    //Deleted PlayList
    public void navigPlayList() {
        WebElement navigatePlayList = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();
    }
    public void rightClicPlayBtn() {
        WebElement rightClickPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .contextClick(rightClickPlaylist)
                .perform();
    }
    public void deleteBtnNavigate() {
        WebElement navigateDeleteButton = driver.findElement(By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]"));
        new Actions(driver)
                .clickAndHold(navigateDeleteButton)
                .perform();
    }

    public void clickDeleteBt() {
        WebElement clickable = driver.findElement(By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]"));
        new Actions(driver)
                .click(clickable)
                .perform();
    }

    public void assertPlayListDeleted() {
        WebElement playListDeleted = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(playListDeleted.isDisplayed());
    }

}

