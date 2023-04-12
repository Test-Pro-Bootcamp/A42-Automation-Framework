package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SongsPage extends BasePage {
    @FindBy(css=".player-controls")
    WebElement playControlPanel;
    @FindBy(css="[data-testid='play-btn']")
    WebElement playSongBtn;
    @FindBy(css="[data-testid='sound-bar-play']")
    WebElement getSoundBar;
    @FindBy(css=".playback")
    WebElement playBackBtn;
    @FindBy(css=".song-item")
    WebElement firstSong;

    @FindBy (css="[data-testid='pause-btn']")
    private WebElement pauseBtn;

    @FindBy(css=".songs")
    private List<WebElement> allSongs;


    public void hoverOverPlayControl() {
       new Actions(driver)
               .moveToElement(waitUntilVisible(playControlPanel))
               .perform();
   }


   public  void playSong() {
       WebElement playBtn = waitUntilVisible(playSongBtn);
       playBtn.click();
   }

    public WebElement getPauseButton() {
        return waitUntilVisible(pauseBtn);
    }

    public List<WebElement> getSongs() {
       return allSongs;
    }

    public WebElement getSoundBar(){
        return waitUntilVisible(this.getSoundBar);
    }

    public void clickPlayBtn() {
        playBackBtn.click();
    }

    public void clickFirstSong() {
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }


}
