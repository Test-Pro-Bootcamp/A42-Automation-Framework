
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistsPage;
import pages.SongsPage;

import java.util.List;
import java.util.Objects;

public class PlaylistPage extends BaseTest {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    PlaylistsPage playlistsPage = new PlaylistsPage();

    SongsPage songsPage = new SongsPage();


    @Test
    public void playSongTest() {
        PageFactory.initElements(getDriver(), loginPage);
        // hover over in clickPlayBtn
        loginPage.login("demo@class.com", "te$t$tudent");
        clickPlayBtn();
        Assert.assertTrue(pauseBtnExists());
        playlistsPage.clickPlayBtn();
        Assert.assertTrue(playlistsPage.pauseBtnExists());

        // Comparing numbers of elements example
        List<WebElement> songs = basePage.getDriver().findElements(By.cssSelector("[data-test='song-card']"));
        List<WebElement> songs = songsPage.getSongs();

        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        @@ -44,15 +50,22 @@ public void playSongTest() {
        }

        @Test
        public void renamePlaylist() {
            public void renamePlaylist() throws InterruptedException {
                PageFactory.initElements(getDriver(), loginPage);
                // double click
                String playlistName = "Summer songs";

                loginPage.login("demo@class.com", "te$t$tudent");
                doubleClickChoosePlaylist();
                enterPlaylistName(playlistName);
                String newName = getPlaylistName();
                String oldName = playlistsPage.getPlaylistName();
                if(oldName.equals(playlistName)){
                    playlistName = "Winter songs";
                }
                System.out.println(playlistName);
                playlistsPage.doubleClickChoosePlaylist();
                playlistsPage.enterPlaylistName(playlistName);
                Thread.sleep(1000);
                String newName = playlistsPage.getPlaylistName();
                System.out.println(newName);
                Assert.assertEquals(playlistName, newName);
            }

            @@ -61,7 +74,7 @@ public void playSongFromListTest() throws InterruptedException {
                PageFactory.initElements(getDriver(), loginPage);
                // right click
                loginPage.login("demo@class.com", "te$t$tudent");
                goToAllSongs();
                playlistsPage.goToAllSongs();
                WebElement firstSong = basePage.getDriver().findElement(By.cssSelector(".song-item"));
                Actions actions = new Actions(basePage.getDriver());
                actions.contextClick(firstSong).perform();
                @@ -71,42 +84,6 @@ public void playSongFromListTest() throws InterruptedException {
                    basePage.waitUntilVisible(By.cssSelector("[data-testid='sound-bar-play']"));
                }

                public void clickPlayBtn() {
                    Actions action = new Actions(basePage.getDriver());
                    WebElement playBtn = basePage.getDriver().findElement(By.cssSelector("[data-testid='play-btn']"));
                    action
                            .moveToElement(playBtn)
                            .perform();
                    playBtn.click();
                }

                public boolean pauseBtnExists() {
                    return basePage.getDriver().findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
                }


                private void goToAllSongs() {
                    basePage.waitUntilClickable(By.cssSelector(".songs")).click();
                }


                public void doubleClickChoosePlaylist() {
                    WebElement playlistElement = basePage.waitUntilClickable(By.cssSelector(".playlist:nth-child(3)"));
                    Actions actions = new Actions(basePage.getDriver());
                    actions.doubleClick(playlistElement).perform();
                }

                public void enterPlaylistName(String name) {
                    WebElement playlistInputField = basePage.getDriver().findElement(By.cssSelector("input[name='name']"));
                    playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
                    playlistInputField.sendKeys(Keys.ENTER);
                }

                private String getPlaylistName() {
                    WebElement playlistElement = basePage.waitUntilVisible(By.cssSelector(".playlist:nth-child(3)>a"));
                    String name = playlistElement.getText();
                    return name;
                }

                @Test
                public void countSongsInPlaylist() {
                    @@ -117,7 +94,7 @@ public void countSongsInPlaylist() {
                        List<WebElement> songs = basePage.getDriver().findElements(By.cssSelector("#playlistWrapper .song-item"));
                        int number = songs.size();
                        //  Assert.assertEquals(number, 4); // can fail, depends on current number. This is just an example


                    }

                }
                39
                src/test/java/pages/PlaylistsPage.java
                @@ -1,14 +1,16 @@
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

                public class PlaylistsPage extends BasePage {

                    By forthPlaylist = By.cssSelector(".playlist:nth-child(3)");

                    public void addSongToPlaylist(){
                        WebElement addToBtn = waitUntilVisible(By.cssSelector("[data-test='add-to-btn']"));
                        addToBtn.click();
                        @@ -24,4 +26,41 @@ public void createNewPlaylistWhileAddingSong(String playlistName){
                .perform();
                        }

                        public void clickPlayBtn() {
                            Actions action = new Actions(driver);
                            WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
                            action
                                    .moveToElement(playBtn)
                                    .perform();
                            playBtn.click();
                        }

                        public boolean pauseBtnExists() {
                            return driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
                        }


                        public void goToAllSongs() {
                            waitUntilClickable(By.cssSelector(".songs")).click();
                        }


                        public void doubleClickChoosePlaylist() {
                            WebElement playlistElement = waitUntilClickable(forthPlaylist);
                            Actions actions = new Actions(driver);
                            actions.doubleClick(playlistElement).perform();
                        }

                        public void enterPlaylistName(String name) {
                            WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
                            playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
                            playlistInputField.sendKeys(Keys.ENTER);
                        }

                        public String getPlaylistName() {
                            WebElement playlistElement = waitUntilVisible(forthPlaylist);
                            String name = playlistElement.getText();
                            return name;
                        }

                    }
  10
                    src/test/java/pages/SongsPage.java
                    @@ -4,11 +4,15 @@
                            import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

                    public class SongsPage extends BasePage {
                        By playControlPanel = By.cssSelector(".player-controls");
                        By playSongBtn = By.cssSelector("[data-testid='play-btn']");
                        By pauseBtn = By.cssSelector("[data-testid='pause-btn']");

                        By songs = By.cssSelector("[data-test='song-card']");

                        public void hoverOverPlayControl() {
                            new Actions(driver)
                                    .moveToElement(waitUntilVisible(playControlPanel))
                            @@ -24,4 +28,10 @@ public  void playSong() {
                                public WebElement getPauseButton(){
                                    return waitUntilVisible(pauseBtn);
                                }

                                public List<WebElement> getSongs() {
                                    return driver.findElements(By.cssSelector("[data-test='song-card']"));
                                }


                            }

