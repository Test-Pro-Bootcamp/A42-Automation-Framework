import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
    public void addPlayList() throws InterruptedException {
        // login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        String plName = "Rock stars 2";
        playListPage.createPlayList(plName);
        List<String> playListNames = playListPage.getplayListNames();
        System.out.println(playListNames);
        Thread.sleep(1000);
        //Assert.assertTrue(playListNames.contains(plName));

    }




}

