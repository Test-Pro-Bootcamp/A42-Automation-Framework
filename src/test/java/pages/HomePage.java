package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    public static HomePage homePage(){
        return new HomePage();
    }
    @FindBy(css=("[type='search']"))
    WebElement searchInput;
    @FindBy(css=("[data-test='view-all-songs-btn']"))
    WebElement viewAllBtn;
    @FindBy(xpath=("//section[@id='songResultsWrapper']//div[@class='song-list-controls']//span[@class='btn-group']/button[@class='btn-add-to']" ))
    WebElement addToButton;
    private By searchResults = By.cssSelector("#songResultsWrapper .song-item");
    private By avatarIcon = By.cssSelector("a .avatar");
    private By successNotification = By.cssSelector(".success.show");
    @FindBy(xpath=("//section[@id='songResultsWrapper']//section/ul/li[5]"))
    WebElement playlist;
    @FindBy(xpath=("//section[@id='playlists']//li[3]"))
    WebElement playlistNm;
    @FindBy(xpath=("//button[@title='Delete this playlist']"))
    WebElement deletePlist;
    @FindBy(css=("button.ok"))
    WebElement deletePlaylistBtn;

    public HomePage search(String text) {
        //WebElement searchInput = waitUntilVisible(searchInput.);
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
        return this;
    }

    public HomePage viewAllSearchResults() {
        //WebElement viewAllBtn = waitUntilVisible(viewAllButton);
        viewAllBtn.click();
        return this;
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
    public HomePage addToPlaylist(){
    //WebElement addToButton = driver.findElement(addSongBtn);
    addToButton.click();
    return this;
}
    public HomePage playlistElem() {
        //WebElement playlist = driver.findElement(playlistElement);
        playlist.click();
        return this;
    }
    public HomePage clickPlaylist() {
        //WebElement playlistNm = driver.findElement(playlistName);
        playlistNm.click();
        return this;
    }
    public void deletePl(){
        //WebElement deletePlist = driver.findElement(deletePlaylist);
        deletePlist.click();
    }
public HomePage okBtnDeletePl(){
    //WebElement deletePlaylistBtn = driver.findElement(deletePlaylistBtnOk);
    deletePlaylistBtn.click();
    return this;
}
}
