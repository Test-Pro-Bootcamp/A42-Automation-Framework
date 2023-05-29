package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {
    LoginPage loginPage = new LoginPage();

    // compare Text ALL Songs Btn
    public String compareALLSongsText() {
        WebElement allSongsBtn = driver.findElement(By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/songs'] "));
        return allSongsBtn.getText();


    }

    //  compare Text Album Btn
    public String compareAlbumText() {
        WebElement albumButton = driver.findElement(By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/albums']"));
        return albumButton.getText();


    }

    //compare Text Recently Btn
    public String compareRecentlyBtn() {
        WebElement recentlyBtn = driver.findElement(By.xpath("//section[@id='playlists']/ul//a[@href='#!/recently-played'] "));
        return recentlyBtn.getText();


    }

    // change the name in the profile
    //click Student btn
    public void clickStudentBtn() throws InterruptedException {
        Thread.sleep(1000);
        WebElement btnStudent = driver.findElement(By.cssSelector(".view-profile .name "));
        btnStudent.click();

    }

    // Find and clear input field
    public void clearNameInputField() throws InterruptedException {
        WebElement inputField = driver.findElement(By.cssSelector("#inputProfileName"));
        Thread.sleep(1000);
        inputField.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        // Enter new student name
        Thread.sleep(1000);
        inputField.sendKeys("Daria 6");
        Thread.sleep(1000);
        inputField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    // Enter current password
    public void enterCurrentPasswordField() throws InterruptedException {
        WebElement inputPasswordField = driver.findElement(By.cssSelector("input#inputProfileCurrentPassword"));
        Thread.sleep(1000);
        inputPasswordField.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        Thread.sleep(1000);
        inputPasswordField.sendKeys("Qazxsw123@Qazxsw123@");
        Thread.sleep(1000);
        inputPasswordField.sendKeys(Keys.ENTER);
    }

    // click save Btn
    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
    }

    // assert compare text
    public boolean newNameBtnIsdisplayed() {
        WebElement newNameBtn = driver.findElement(By.xpath("//span[@id='userBadge']//span[@class='name']"));
        Assert.assertTrue(newNameBtn.isDisplayed());
        return true;
    }

}
