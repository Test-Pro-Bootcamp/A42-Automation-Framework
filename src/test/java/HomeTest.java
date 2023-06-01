import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test (priority = 1, description = "all songs")
    public void allSongs(){
        // Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // navigate All Songs
        String actualAllSongs = homePage.compareALLSongsText();
        String expectedResult = "All Songs";
        Assert.assertEquals(actualAllSongs,expectedResult);
    }

    @Test (priority = 2, description = "all Albums")
    public void albumsBtn() {
        //Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        //navigate album button
        String actualAlbum = homePage.compareAlbumText();
        String expectedAlbum = "Albums";
        Assert.assertEquals(actualAlbum, expectedAlbum);
    }

    @Test (priority = 3, description = "recently Played")
    public void recentlyPLBtn() {
        //Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        //navigate recently Played button
        String actualRecently = homePage.compareRecentlyBtn();
        String expectedRecently = "Recently Played";
        Assert.assertEquals(actualRecently, expectedRecently);

    }

    @Test (priority = 4, description = "Profile Name")
    public  void studentBtn() throws InterruptedException {
        //Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // click student Button
        homePage.clickStudentBtn();
        //Find and clear input field
        homePage.clearNameInputField();
        // Enter current password
        homePage.enterCurrentPasswordField();
        // click save Btn
        homePage.clickSaveBtn();
        // assert new name is displayed
        homePage.newNameBtnIsdisplayed();

    }


}
