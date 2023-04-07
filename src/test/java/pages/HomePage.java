package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage{

    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("[data-test='view-all-songs-btn']");
    By addSongBtn = By.xpath("//section[@id='songResultsWrapper']//div[@class='song-list-controls']//span[@class='btn-group']/button[@class='btn-add-to']" );
    By searchResults = By.cssSelector("#songResultsWrapper .song-item");
    By avatarIcon = By.cssSelector("a .avatar");
    By successNotification = By.cssSelector(".success.show");
    By playlistElement = By.xpath("//section[@id='songResultsWrapper']//section/ul/li[5]");
    By playlistName = By.xpath("//section[@id='playlists']//li[3]");
    By deletePlaylist = By.xpath("//button[@title='Delete this playlist']");
    By deletePlaylistBtnOk = By.cssSelector("button.ok");

    public void search(String text) {
        WebElement searchInput =
                waitUntilVisible(searchField);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public void viewAllSearchResults() {
        WebElement viewAllBtn = waitUntilVisible(viewAllButton);
        viewAllBtn.click();
    }

    public void clickFirstSearchResult() {
        List<WebElement> songResults = driver.findElements(searchResults);
        songResults.get(0).click();
    }

    public WebElement getSuccessBanner(){

        return waitUntilVisible(successNotification);
    }

    public WebElement getAvatar(){

        return waitUntilVisible(avatarIcon);
    }

    public boolean pauseBtnExists() {
        return getDriver().findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }

    public void goToAllSongs() {
        waitUntilClickable(By.cssSelector(".songs")).click();
    }

    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = waitUntilClickable(By.cssSelector(".playlist:nth-child(3)"));
        Actions actions = new Actions(getDriver());
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = getDriver().findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        WebElement playlistElement = waitUntilVisible(By.cssSelector(".playlist:nth-child(3)>a"));
        String name = playlistElement.getText();
        return name;
    }
    public void enterPlaylistName() {
        WebElement playlistInputField = getDriver().findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Homework-22");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void addToPlaylist(){
    WebElement addToButton = driver.findElement(addSongBtn);
    addToButton.click();
}
    public void playlistElem() {
        WebElement playlist = driver.findElement(playlistElement);
        playlist.click();
    }
    public void clickPlaylist() {
        WebElement playlistNm = driver.findElement(playlistName);
        playlistNm.click();
    }
    public void deletePl(){
        WebElement deletePlist = driver.findElement(deletePlaylist);
        deletePlist.click();
    }
public void okBtnDeletePl(){
    WebElement deletePlaylistBtn = driver.findElement(deletePlaylistBtnOk);
    deletePlaylistBtn.click();
}
}
