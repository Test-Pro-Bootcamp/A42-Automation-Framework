import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistsPage;
import pages.SongsPage;

import java.util.List;

public class PlaylistTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    PlaylistsPage playlistsPage = new PlaylistsPage();

    SongsPage songsPage = new SongsPage();

    @Test
    public void playSongTest() {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        // hover over in clickPlayBtn
        loginPage.login("anna.stonaieva@testpro.io", "te$t$tudent");
        clickPlayBtn();
        Assert.assertTrue(pauseBtnExists());
        playlistsPage.clickPlayBtn();
        Assert.assertTrue(playlistsPage.pauseBtnExists());

        // Comparing numbers of elements example
        List<WebElement> songs = songsPage.getSongs();

        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
    }

    @Test
    public void renamePlaylist() throws InterruptedException {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        // double click
        String playlistName = "Summer songs";

        loginPage.login("demo@class.com", "te$t$tudent");
        doubleClickChoosePlaylist();
        enterPlaylistName(playlistName);
        String newName = getPlaylistName();
        String oldName = playlistsPage.getPlaylistName();
        if (oldName.equals(playlistName)) {
            playlistName = "Winter songs";
        }
        System.out.println(playlistName);
        playlistsPage.doubleClickChoosePlaylist();
        playlistsPage.enterPlaylistName(playlistName);
        Thread.sleep(1000);
 //       String newName = playlistsPage.getPlaylistName();
        System.out.println(newName);
        Assert.assertEquals(playlistName, newName);
    }

    public void playSongFromListTest() throws InterruptedException {
        PageFactory.initElements(basePage.getDriver(), loginPage);
        // right click
        loginPage.login("anna.stonaieva@testpro.io", "te$t$tudent");
        goToAllSongs();
        playlistsPage.goToAllSongs();
        WebElement firstSong = basePage.getDriver().findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(basePage.getDriver());
        actions.contextClick(firstSong).perform();
    }

    public void clickPlayBtn() {
        Actions action = new Actions(basePage.getDriver());
        WebElement playBtn = basePage.getDriver().findElement(By.cssSelector("[data-testid='play-btn']"));
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return basePage.getDriver().findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }

    private void goToAllSongs() {
        basePage.waitUntilClickable(By.cssSelector(".songs")).click();
    }

    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = basePage.waitUntilClickable(By.cssSelector(".playlist:nth-child(3)"));
        Actions actions = new Actions(basePage.getDriver());
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = basePage.getDriver().findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private String getPlaylistName() {
        WebElement playlistElement = basePage.waitUntilVisible(By.cssSelector(".playlist:nth-child(3)>a"));
        String name = playlistElement.getText();
        return name;
    }

    @Test
    public void countSongsInPlaylist() {
        List<WebElement> songs = basePage.getDriver().findElements(By.cssSelector("#playlistWrapper .song-item"));
        int number = songs.size();
        //  Assert.assertEquals(number, 4); // can fail, depends on current number. This is just an example


    }

}
