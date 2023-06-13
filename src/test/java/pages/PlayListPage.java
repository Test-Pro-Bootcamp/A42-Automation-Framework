package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class PlayListPage extends BasePage {
    LoginPage loginPage = new LoginPage();

    // Locators create New PlayList
    //navigate PlayList
    By createPlayListBtn = By.cssSelector("[title='Create a new playlist'] ");
    // click playList
    By clickPlayList = By.cssSelector("[title='Create a new playlist']");
    // navigate New playList
    By navigateNewPlayL = By.cssSelector("[data-testid='playlist-context-menu-create-simple'] ");
    // click New PlayL
    By clickNewPlayL = By.cssSelector("[data-testid='playlist-context-menu-create-simple'] ");
    // navigate field create New playList
    By navigateFildNewPlayL = By.xpath("//form[@name='create-simple-playlist-form']//input");
    // create New name Playlist
    By createNewName = By.xpath("//form[@name='create-simple-playlist-form']//input ");
    // Assert New name playList
    By assertNewName = By.cssSelector(".success.show");

    // Locators Delete PlayList
    By navigateNewPL = By.xpath("//li[@class='playlist playlist']");
    // right click PlayList
    By rightClicPL = By.xpath("//li[@class='playlist playlist']");
    // navigate delete Btn
    By navigateDeletePLBtn = By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]");
    // click delete Btn
    By clickDeleteBtn = By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]");
    // Assert playList deleted
    By assertPLDeleted = By.cssSelector(".success.show");

    // rename play List - navigate PLBtn
    By navigatePLBtn = By.xpath("//li[@class='playlist playlist'][1] ");
    // click PLB
    By clickPLBtn = By.xpath("//li[@class='playlist playlist'][1]");
    // click relese PLBtn
    By clickRelesePLBtn = By.xpath("//li[@class='playlist playlist'][1]");
    // input field name
    By inputFieldPl = By.cssSelector("input[name='name']");
    // navigate New pL
    By navigateNPL = By.xpath("//li[@class='playlist playlist'][1]");

    //add new song - click BtnAllSongs
    By clickBtnAllSong = By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/songs']");
    // navigate SongBtn
    By navigateSongBtn = By.cssSelector(".all-songs .song-item:nth-of-type(5) .title");
    // click BtnAdd
    By clickAddBtn = By.cssSelector(".btn-add-to ");
    // navigate PLQ
    By navigatePLQ = By.xpath("//li[@class='playlist playlist'][2]");


    // Created PlayList
    public void navigatePlayListBtn() {
        WebElement createPlayListButton = driver.findElement(createPlayListBtn);
        new Actions(driver)
                .contextClick(createPlayListButton)
                .perform();
    }


    public void clickPlayListBtn() {
        WebElement clickPlayListButton = driver.findElement(clickPlayList);
        new Actions(driver)
                .click(clickPlayListButton)
                .perform();
    }

    public void navigateNewPlaylistBtn() {
        WebElement newPlayListButton = driver.findElement(navigateNewPlayL);
        new Actions(driver)
                .contextClick(newPlayListButton)
                .perform();
    }

    public void clickNewPlayListBtn() {
        WebElement clickNewPlayListButton = driver.findElement(clickNewPlayL);
        new Actions(driver)
                .click(clickNewPlayListButton)
                .perform();
    }

    public void navigateField() {
        WebElement navigateFieldCreatePlayList = driver.findElement(navigateFildNewPlayL);
        new Actions(driver)
                .contextClick(navigateFieldCreatePlayList)
                .perform();
    }

    public void newNamePlayList() throws InterruptedException {
        WebElement addplayListNameField = driver.findElement(createNewName);
        addplayListNameField.click();
        addplayListNameField.clear();
        Thread.sleep(1000);
        addplayListNameField.sendKeys("Di1");
        new Actions(driver).keyDown(Keys.ENTER).perform();
    }

    public void assertNewPlayListAppeared() throws InterruptedException {
        WebElement playListCreated = driver.findElement(assertNewName);
        Thread.sleep(1000);
        Assert.assertTrue(playListCreated.isDisplayed());
    }

    //Deleted PlayList
    public void navigPlayList() {
        WebElement navigatePlayList = driver.findElement(navigateNewPL);
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();
    }

    public void rightClicPlayBtn() {
        WebElement rightClickPlaylist = driver.findElement(rightClicPL);
        new Actions(driver)
                .contextClick(rightClickPlaylist)
                .perform();
    }

    public void deleteBtnNavigate() {
        WebElement navigateDeleteButton = driver.findElement(navigateDeletePLBtn);
        new Actions(driver)
                .clickAndHold(navigateDeleteButton)
                .perform();
    }

    public void clickDeleteBt() {
        WebElement clickable = driver.findElement(clickDeleteBtn);
        new Actions(driver)
                .click(clickable)
                .perform();
    }

    public void assertPlayListDeleted() throws InterruptedException {
        WebElement playListDeleted = driver.findElement(assertPLDeleted);
        waitUntilVisible(playListDeleted);
        Assert.assertTrue(playListDeleted.isDisplayed());
    }


    // rename PlayList
    public void getNavigatePlayList() {
        WebElement navigatePlayList = driver.findElement(navigatePLBtn);
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();

    }

    public void leftClickPlaylistButton() {
        WebElement leftClickPlaylistButton = driver.findElement(clickPLBtn);
        new Actions(driver)
                .doubleClick(leftClickPlaylistButton)
                .perform();
    }

    public void clickReleasePlayListButton() throws InterruptedException {
        WebElement clickReleasePlayListButton = driver.findElement(clickRelesePLBtn);
        new Actions(driver)
                .click(clickReleasePlayListButton)
                .perform();
    }

    public void playlistInputField() throws InterruptedException {
        WebElement playlistInputField = driver.findElement(inputFieldPl);
        Thread.sleep(2000);
        playlistInputField.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        playlistInputField.sendKeys("Sasha");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void navigatePlayList() throws InterruptedException {
        WebElement navigatePlayListNew = driver.findElement(navigateNPL);
        Thread.sleep(2000);
        Assert.assertTrue(navigatePlayListNew.isDisplayed());


    }

    public void clickBtnAllSongs() {
        WebElement btnALLSongs = driver.findElement(clickBtnAllSong);
        btnALLSongs.click();

    }

    public void navigateSong() {
        WebElement songBtn = driver.findElement(navigateSongBtn);
        songBtn.click();
    }

    public void clickBtnADDTo() {
        WebElement btnADDTo = driver.findElement(clickAddBtn);
        btnADDTo.click();
    }

    public void navigatePlayListQ() {
        WebElement playListBtn = driver.findElement(navigatePLQ);
        playListBtn.click();
    }

    public boolean addedNewSong() {
        WebElement newSongADD = driver.findElement(By.cssSelector(".playlist .virtual-scroller .title"));
        Assert.assertTrue(newSongADD.isDisplayed());
        return true;
    }

    // Rename playlist #2
    public void navigatePLBtn() {
        WebElement PlayList = driver.findElement(By.xpath("//li[@class='playlist playlist'][14]"));
        new Actions(driver)
                .contextClick(PlayList)
                .perform();
    }

    public void dblClickPL() {
        WebElement playListB = driver.findElement(By.xpath("//li[@class='playlist playlist'][14] "));
        new Actions(driver)
                .doubleClick(playListB)
                .perform();
    }

    public void selectPLName() throws InterruptedException {
        WebElement playLInputField = driver.findElement(By.cssSelector("input[name='name'] "));
        Thread.sleep(2000);
        playLInputField.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        Thread.sleep(1000);
        playLInputField.sendKeys("King41");
        playLInputField.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public boolean isDisplayedNewPL() {
        WebElement newPlayListName = driver.findElement(By.xpath("//li[@class='playlist playlist'][4]"));
        Assert.assertTrue(newPlayListName.isDisplayed());
        return true;
    }

    // Play songs test
    public void clickAllSongsBtn() {
        WebElement allSongsBtn = driver.findElement(By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/songs']"));
        allSongsBtn.click();
    }

    public void doubleClickSongBtn() {
        WebElement songBtn = driver.findElement(By.cssSelector(".all-songs [draggable='true']:nth-of-type(6) .title "));
        new Actions(driver)
                .doubleClick(songBtn)
                .perform();
    }

    public boolean asssertEqualizerPlaying() {
        WebElement equalizerBtn = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(equalizerBtn.isDisplayed());
        return true;
    }

    public void createPlayList(String plName) {
        // click create playList
        WebElement createPlBtn = driver.findElement(By.xpath("//section[@id='playlists']//i[@role='button'] "));
        createPlBtn.click();
        // new PLBtn
        WebElement newPLBtn = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple'] "));
        newPLBtn.click();

        // enter PL name
        WebElement pLNameField = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name'] "));
        pLNameField.click();
        pLNameField.clear();
        waitUntilVisible(pLNameField);
        pLNameField.sendKeys("Rock Stars 5");
        pLNameField.sendKeys(Keys.ENTER);
        waitUntilVisible(driver.findElement(By.xpath("//*[text()='" + plName + "']")));

    }

    public List<String> getplayListNames() {
        List<String> playListNames = new ArrayList<>();
        List<WebElement> playLists = waitForElementsVisibility(driver.findElements(By.xpath("//li[@class='playlist playlist']")));

        for (WebElement playList : playLists) {
            playListNames.add(playList.getText());
        }
        return playListNames;

    }

    // play songs in Albums
    public void clickAlbumsBtn() throws InterruptedException {
        WebElement albumBtn = driver.findElement(By.xpath("//nav[@id='sidebar']/section[@class='music']//a[@href='#!/albums']"));
        Thread.sleep(1000);
        albumBtn.click();
    }

    public void chooseAlbums() {
        WebElement selectAlbums = driver.findElement(By.xpath("/html//section[@id='albumsWrapper']//article[@title='Defunct by Metre']//a[@href='#!/album/10']"));
        selectAlbums.click();
    }

    public void doubleClickSong() {
        WebElement songName = driver.findElement(By.xpath("//section[@id='albumWrapper']/div//table[@class='items']//td[@class='title'] "));
        new Actions(driver)
                .doubleClick(songName)
                .perform();
    }

    public boolean assertEqualaizerIsDespl() {
        WebElement equalaizerBtn = driver.findElement(By.xpath("//footer[@id='mainFooter']//button[@title='Click for a marvelous visualizer!']/div[@class='bars']/img[@alt='Sound bars'] "));
        Assert.assertTrue(equalaizerBtn.isDisplayed());
        return true;
    }

}





