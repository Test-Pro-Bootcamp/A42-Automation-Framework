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

    @Test
    public  void studentBtn() throws InterruptedException {
        //Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        // navigate student Btn
        Thread.sleep(1000);
        // click student Button
        WebElement btnStudent = getBasePage().getDriver().findElement(By.cssSelector(".view-profile .name "));
        btnStudent.click();
        // enter password
        WebElement inputPasswordField =getBasePage().getDriver().findElement(By.cssSelector("input#inputProfileCurrentPassword"));
        Thread.sleep(1000);
        inputPasswordField.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
        Thread.sleep(1000);
        inputPasswordField.sendKeys("Qazxsw123@Qazxsw123@");
        Thread.sleep(1000);
        inputPasswordField.sendKeys(Keys.ENTER);

        //click input field
        WebElement inputField = getBasePage().getDriver().findElement(By.cssSelector("#inputProfileName  "));
        Thread.sleep(1000);
        inputField.sendKeys(Keys.CONTROL,"a", Keys.BACK_SPACE);
        Thread.sleep(1000);
        inputField.sendKeys("Daria 3 ");
        Thread.sleep(1000);
        inputField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        // click save Btn
        WebElement saveBtn = getBasePage().getDriver().findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();



    }


}
