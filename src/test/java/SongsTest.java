import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

import java.util.List;

public class SongsTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    SongsPage songsPage = new SongsPage();

    @Test
    public void addPlayList(){
        // Login
        loginPage.login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");
        //get songs
       // List<String> songsName = getBasePage().getDriver().findElements(By.cssSelector(".playlist.playlist>a"))

    }
}
