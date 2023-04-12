package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public static HomePage homePage() {
        return new HomePage();
    }

    @FindBy(css = "[data-test='view-all-songs-btn']")
    private WebElement viewAllBtn;
    @FindBy(css="[type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//div[@class='song-list-controls']//span[@class='btn-group']/button[@class='btn-add-to']")
    private WebElement viewAllSearchResults;
    @FindBy(css = ".success.show")
    private WebElement successNotification;
    @FindBy(css = "#songResultsWrapper .song-item")
    private List<WebElement> allSongsResult;
    @FindBy(css="a .avatar")
    private WebElement avatar;

    public void  search(String text) {
        WebElement searchInput =
                waitUntilVisible(this.searchField );
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public HomePage viewAllSearchResults() {
        WebElement viewAllBtn = waitUntilVisible(this.viewAllBtn);
        viewAllBtn.click();
        return this;
    }

    public HomePage clickFirstSearchResult() {
        allSongsResult.get(0).click();
        return this;
    }

    public WebElement getSuccessBanner() {
        return successNotification;
    }

    public WebElement getAvatar() {
        return waitUntilVisible(avatar);
    }
}
