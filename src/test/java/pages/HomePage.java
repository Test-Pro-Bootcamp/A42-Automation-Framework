package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{
    LoginPage loginPage = new LoginPage();

    // compare Text ALL Songs Btn
    public String compareALLSongsText(){
        WebElement allSongsBtn = driver.findElement(By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/songs'] "));
        return allSongsBtn.getText();



    }
    //  compare Text Album Btn
    public String compareAlbumText(){
        WebElement albumButton = driver.findElement(By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/albums']"));
         return albumButton.getText();


    }

    //compare Text Recently Btn
    public String compareRecentlyBtn(){
        WebElement recentlyBtn = driver.findElement(By.xpath("//section[@id='playlists']/ul//a[@href='#!/recently-played'] "));
         return recentlyBtn.getText();

    }

}
