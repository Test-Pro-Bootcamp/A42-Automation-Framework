import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlayListPage;

import java.util.ArrayList;
import java.util.List;

public class PlayListTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    PlayListPage playListPage = new PlayListPage();
    BasePage basePage = new BasePage();


    @Test (priority = 1, description = "create Playlist")
    public void createPlayListTest() throws InterruptedException {
        // Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        //navigate create playList button
        playListPage.navigatePlayListBtn();
        //click create playList button
        playListPage.clickPlayListBtn();
        //navigate New Playlist button
        playListPage.navigateNewPlaylistBtn();
        // click New Playlist button
        playListPage.clickNewPlayListBtn();
        // navigate field
        playListPage.navigateField();
        //add name New Playlist
        playListPage.newNamePlayList();
        //assert playlist appeared
        playListPage.assertNewPlayListAppeared();
    }

    @Test (priority = 3, description = "rename PlayList")
    public void renamePlayList() throws InterruptedException {
        // Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        playListPage.getNavigatePlayList();
        playListPage.leftClickPlaylistButton();
        playListPage.clickReleasePlayListButton();
        playListPage.playlistInputField();
        //Assert.assertEquals(playListPage.navigatePlayList(),"Sasha ");
        playListPage.navigatePlayList();
    }


    @Test (priority = 2, description = "delete PlayList")
    public void deletePlayListTest() throws InterruptedException {
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");

        //navigate playlist
        playListPage.navigPlayList();
        //right click playlist
        playListPage.rightClicPlayBtn();
        //navigate delete button
        playListPage.deleteBtnNavigate();
        //click delete button
        playListPage.clickDeleteBt();
        //assert playlist deleted
        playListPage.assertPlayListDeleted();
    }
    // create New PlayList
    @Test
     public void PlayListN (){
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // click button (+)
        loginPage.clickBTnPlus();
        // navigate New PlayList btn
        loginPage.navigateNPLBtn();
        // input field
        loginPage.clickInpField();
        // assert play List create
        loginPage.playListIsDisplayed();

    }

    // rename playList
    @Test
    public void NewNamePlayList() throws InterruptedException {
        // Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // navigate playList Btn
        playListPage.navigatePLBtn();
        // double click playList Btn
        playListPage.dblClickPL();
        // add new name in field
        playListPage.selectPLName();
        // new play List is created
        playListPage.isDisplayedNewPL();

    }
    // add new song in PL
    @Test
    public void addNewSongInPlayList(){
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // navigate and click Btn AllSongs
        playListPage.clickBtnAllSongs();
        // navigate song
        playListPage.navigateSong();
        // click Btn ADD TO
       playListPage.clickBtnADDTo();
        //navigate Play List Q
        playListPage.navigatePlayListQ();
        //song added in playList
        playListPage.addedNewSong();
    }
    // delete song from PlayList King4
    @Test
    public void playSongs() throws InterruptedException {
        // login
        loginPage.login("dsalina1984@gmail.com ", "Qazxsw123@Qazxsw123@");
        // click All songs button
        playListPage.clickAllSongsBtn();
        // doubleClick a song
       playListPage.doubleClickSongBtn();
        // assert song is playing
       playListPage.asssertEqualizerPlaying();


    }
    // collection play Lists
    @Test
    public void addPlayList(){
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        String plName = "Rock stars 5";
        playListPage.createPlayList(plName);
        List<String> playListNames = playListPage.getplayListNames();
        System.out.println(playListNames);
        System.out.println(playListNames.contains(plName));
        Assert.assertTrue(playListNames.contains(plName));

    }

    @Test
    public void playSongsInAlbums(){
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // click Albums Btn
        playListPage.clickAlbumsBtn();
        // choose and click albums
        playListPage.chooseAlbums();
        // double click on song
        playListPage.doubleClickSong();
        // asser equalaizer visible
        playListPage.assertEqualaizerIsDespl();
    }
    @Test
    public void playSongArtist(){
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // click Btn Artist
        playListPage.clickArtistBtn();
        // choose Artist
        playListPage.chooseBtnArtist();
        // double click Artist name
        playListPage.doubleClickBtnSong();
        // assert equalaizerPlayed
        playListPage.assertArtistSongPlayed();
    }
    @Test
    public void addSongsToCurrentQueue()  {
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // click buttn ALLSongs
        playListPage.clickBtnAllSong();
        //select songs
        playListPage.chooseAddBtn();
        // right click buttn songs
        playListPage.clickRightBtn();
        // click button Add To
        playListPage.clickButtnAddTo();
        // click btn after current queue
        playListPage.clickBtnCurrentQueue();
        // click list currebt Queue
        playListPage.currentQueueInclude();
        // Assert song is desplayed in current queue list
        playListPage.assertCurrentQueueIncludeSong();
    }

    // add songs in Favorite
    @Test
    public void addSongsFavorites() throws InterruptedException {
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // click Btn AllSongs
        WebElement btnAllsongs = basePage.getDriver().findElement(By.cssSelector(".songs"));
        btnAllsongs.click();
        // choose song Dark Days
        WebElement songChoose = basePage.getDriver().findElement(By.cssSelector(".all-songs .song-item:nth-of-type(11) .title "));
        songChoose.click();
        //  click on hurt
        WebElement btnHurt = basePage.getDriver().findElement(By.cssSelector(".all-songs .song-item:nth-of-type(11) .favorite"));
        btnHurt.click();
        // open Favorites and find song
        WebElement btnFavorites = basePage.getDriver().findElement(By.cssSelector("[href='\\#\\!\\/favorites']"));
        btnFavorites.click();
        // Assert song added to Favorites
        //WebElement songAddedFavorites = basePage.getDriver().findElement(By.cssSelector(".all-songs .song-item:nth-of-type(11) .title "));
        //Thread.sleep(1000);
        //Assert.assertTrue(songAddedFavorites.isDisplayed());

    }

}

