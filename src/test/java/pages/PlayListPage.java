package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class PlayListPage extends BasePage {
    LoginPage loginPage = new LoginPage();

    // Locators create New PlayList
    //navigate PlayList
    By createPlayListBtn = By.cssSelector("[title='Create a new playlist']");
    // click playList
    By clickPlayList = By.cssSelector("[title='Create a new playlist']");
      // navigate New playList
      By navigateNewPlayL = By.cssSelector("[data-testid='playlist-context-menu-create-simple'] ");
      // click New PlayL
       By clickNewPlayL = By.cssSelector("[data-testid='playlist-context-menu-create-simple'] ");
       // navigate field create New playList
       By navigateFildNewPlayL = By.xpath("//form[@name='create-simple-playlist-form']//input");
       // create New name Playlist
       By createNewName = By.xpath("//form[@name='create-simple-playlist-form']//input");
       // Assert New name playList
       By assertNewName = By.cssSelector(".success.show");

       // Locators Delete PlayList
      By navigateNewPL = By.xpath("//li[@class='playlist playlist']");
      // right click PlayList
       By rightClicPL = By.xpath("//li[@class='playlist playlist']");
       // navigate delete Btn
      By navigateDeletePLBtn = By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]");
      // click delete Btn
      By clickDeleteBtn = By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]");
      // Assert playList deleted
      By assertPLDeleted = By.cssSelector(".success.show");




    // Created PlayList
    public void navigatePlayListBtn() {
        WebElement createPlayListButton = driver.findElement(createPlayListBtn);
        new Actions(driver)
                .contextClick(createPlayListButton)
                .perform();
    }


    public void clickPlayListBtn() {
        WebElement clickPlayListButton = driver.findElement(clickPlayList);
        new Actions(driver)
                .click(clickPlayListButton)
                .perform();
    }

    public void navigateNewPlaylistBtn() {
        WebElement newPlayListButton = driver.findElement(navigateNewPlayL);
        new Actions(driver)
                .contextClick(newPlayListButton)
                .perform();
    }
    public void clickNewPlayListBtn() {
        WebElement clickNewPlayListButton = driver.findElement(clickNewPlayL);
        new Actions(driver)
                .click(clickNewPlayListButton)
                .perform();
    }
    public void navigateField() {
        WebElement navigateFieldCreatePlayList = driver.findElement(navigateFildNewPlayL);
        new Actions(driver)
                .contextClick(navigateFieldCreatePlayList)
                .perform();
    }
    public void newNamePlayList() throws InterruptedException {
        WebElement addplayListNameField = driver.findElement(createNewName);
        addplayListNameField.click();
        addplayListNameField.clear();
        Thread.sleep(1000);
        addplayListNameField.sendKeys("Di1");
        new Actions(driver).keyDown(Keys.ENTER).perform();
    }
    public void assertNewPlayListAppeared() throws InterruptedException {
        WebElement playListCreated = driver.findElement(assertNewName);
        Thread.sleep(1000);
        Assert.assertTrue(playListCreated.isDisplayed());
    }

    //Deleted PlayList
    public void navigPlayList() {
        WebElement navigatePlayList = driver.findElement(navigateNewPL);
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();
    }
    public void rightClicPlayBtn() {
        WebElement rightClickPlaylist = driver.findElement(rightClicPL);
        new Actions(driver)
                .contextClick(rightClickPlaylist)
                .perform();
    }
    public void deleteBtnNavigate() {
        WebElement navigateDeleteButton = driver.findElement(navigateDeletePLBtn);
        new Actions(driver)
                .clickAndHold(navigateDeleteButton)
                .perform();
    }

    public void clickDeleteBt() {
        WebElement clickable = driver.findElement(clickDeleteBtn);
        new Actions(driver)
                .click(clickable)
                .perform();
    }

    public void assertPlayListDeleted() throws InterruptedException {
        WebElement playListDeleted = driver.findElement(assertPLDeleted);
        Thread.sleep(1000);
        Assert.assertTrue(playListDeleted.isDisplayed());
    }


    // rename PlayList
    public void  getNavigatePlayList() {
        WebElement navigatePlayList = driver.findElement(By.xpath("//li[@class='playlist playlist'][1]"));
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();

    }

    public void leftClickPlaylistButton (){
        WebElement leftClickPlaylistButton = driver.findElement(By.xpath("//li[@class='playlist playlist'][1]"));
        new Actions(driver)
                .doubleClick(leftClickPlaylistButton)
                .perform();
    }

    public void clickReleasePlayListButton() throws InterruptedException {
        WebElement clickReleasePlayListButton = driver.findElement(By.xpath("//li[@class='playlist playlist'][1]"));
        new Actions(driver)
                .click(clickReleasePlayListButton)
                .perform();
    }
    public void playlistInputField() throws InterruptedException {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name'] "));
        Thread.sleep(2000);
        playlistInputField.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
        playlistInputField.sendKeys("Sasha");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void navigatePlayList() throws InterruptedException {
        WebElement navigatePlayListNew = driver.findElement(By.xpath("//li[@class='playlist playlist'][1]"));
        Thread.sleep(2000);
        Assert.assertTrue(navigatePlayListNew.isDisplayed());


    }


}

