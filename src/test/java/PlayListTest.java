import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlayListPage;

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
        WebElement PlayList = basePage.getDriver().findElement(By.xpath("//li[@class='playlist playlist'][14]"));
        new Actions(basePage.getDriver())
         .contextClick(PlayList)
                .perform();

        // double click playList Btn
        WebElement playListB = basePage.getDriver().findElement(By.xpath("//li[@class='playlist playlist'][14] "));
        new Actions(basePage.getDriver())
                .doubleClick(playListB)
                .perform();
        // select Play List
       // WebElement releasePList = basePage.getDriver().findElement(By.xpath("//li[@class='playlist playlist'][14] "));
       //Thread.sleep(2000);
        //new Actions(basePage.getDriver())
               // .click(releasePList)
               // .perform();

        // add new name in field
        WebElement playLInputField = basePage.getDriver().findElement(By.cssSelector("input[name='name'] "));
        Thread.sleep(2000);
        playLInputField.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
        playLInputField.sendKeys("King2");
        playLInputField.sendKeys(Keys.ENTER);





    }




}

