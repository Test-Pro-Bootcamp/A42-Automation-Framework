import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlayListPage;

public class PlayListTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    PlayListPage playListPage = new PlayListPage();


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

    @Test (priority = 2, description = "rename PlayList")
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


    @Test (priority = 3, description = "delete PlayList")
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


}

