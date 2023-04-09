package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePage {
        private By playControlPanel = By.cssSelector(".player-controls");
        private By playSongBtn = By.cssSelector("[data-testid='play-btn']");
        private By pauseBtn = By.cssSelector("[data-testid='pause-btn']");

        public void hoverOverPlayControl() {
            new Actions(driver)
                    .moveToElement(waitUntilVisible(playControlPanel))
                    .perform();
        }


        public  void playSong() {
            WebElement playBtn = waitUntilVisible(playSongBtn);
            playBtn.click();
        }

        public WebElement getPauseButton(){

            return waitUntilVisible(pauseBtn);
        }
}
