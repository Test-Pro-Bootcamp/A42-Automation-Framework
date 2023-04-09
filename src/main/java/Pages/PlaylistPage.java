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


