import java.util.UUID;


public class Homework17 extends BaseTest {

   /* @Test
    public void successfulLoginTest() {

        login("demo@class.com", "te$t$tudent");
        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys("te$t$tudent");

        String newName = generateRandomName();

        WebElement userNameField = driver.findElement(By.id("inputProfileName"));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);

        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();

        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        String name = profileName.getText();
        Assert.assertEquals(newName, name);
    }

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotificationText = "Added 1 song into";

        setUpEmail("demo@class.com");
        setUpPassword("te$t$tudent");
        clickLoginButton();


        String song = "Waiting On A Train";

        //login
        login("demo@class.com", "te$t$tudent");

        //search song
        WebElement searchSong= driver.findElement(By.cssSelector("[type='search']"));
        searchSong.click();
        searchSong.clear();
        searchSong.sendKeys(song);

        WebElement clickViewAllSearchResult = driver.findElement(By.cssSelector("section.songs h1 button"));
        clickViewAllSearchResult.click();
        Thread.sleep(2000);

        //view all songs
        //WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        //viewAllBtn.click();
        //Thread.sleep(1000);

        //search results


        //select first song
        WebElement viewAllFirstResults = driver.findElement(By.cssSelector("#songResultsWrapper .song-item"));
        viewAllFirstResults.click();

        //add to playlist
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();

        //create a new playlist
        WebElement listNameField = driver.findElement(By.cssSelector("[data-test='new-playlist-name']"));
        listNameField.click();
        //listNameField.clear();
        //listNameField.sendKeys("julia olay");
        //new Actions(driver)
                //.keyDown(Keys.ENTER)
               // .perform();
        WebElement successBanner = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(successBanner.isDisplayed());

        Thread.sleep(1000);

    */
    }

   /* public void login(String email, String password) {
        basePage.setUpEmail(email);
        basePage.setUpPassword(password);
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }
}
    */

