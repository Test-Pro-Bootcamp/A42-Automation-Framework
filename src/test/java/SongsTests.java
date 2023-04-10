
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTests extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {

        login("chernyakma75@gmail.com","te$t$tudent" );

        WebElement hover = driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
               .moveToElement(hover)
               .perform();
        Thread.sleep(5000);
        hover.click();
        WebElement pause=driver.findElement(By.cssSelector("[class='pause']"));
        Assert.assertTrue(pause.isDisplayed());

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistsPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    PlaylistsPage playlistsPage = new PlaylistsPage();
    SongsPage songsPage = new SongsPage();

    @Test
    public void addSongToPlaylist() {

        String song = "Waiting on a train";
        PageFactory.initElements(getDriver(), loginPage);
        // login
        loginPage.login("demo@class.com", "te$t$tudent");
        // search song
        homePage.search(song);
        // click view all
        homePage.viewAllSearchResults();
        // click on the first song
        homePage.clickFirstSearchResult();
        // click add to playlist
        playlistsPage.addSongToPlaylist();
        // create a new playlist
        playlistsPage.createNewPlaylistWhileAddingSong("123");
        Assert.assertTrue(homePage.getSuccessBanner().isDisplayed());
    }

    @Test
    public void playSong() {
        PageFactory.initElements(getDriver(), loginPage);
        // login
        loginPage.login("demo@class.com", "te$t$tudent");
        // hover
        songsPage.hoverOverPlayControl();
        // start song
        songsPage.playSong();
        // assert
        Assert.assertTrue(songsPage.getPauseButton().isDisplayed());

    }
}
