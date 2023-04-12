package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public String getProfileName() {
        WebElement profileName = driver.findElement(By.cssSelector("span.name"));
        return profileName.getText();
    }

    public ProfilePage saveProfile() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
        return this;
    }

    public ProfilePage enterNewName(String newName) {
        WebElement userNameField = driver.findElement(By.id("inputProfileName"));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(newName);
        return this;
    }

    public ProfilePage enterCurrentEmail(String email) {
        WebElement currentEmailField = driver.findElement(By.id("inputProfileEmail"));
        currentEmailField.click();
        currentEmailField.clear();
        currentEmailField.sendKeys(email);
        return this;
    }

    public ProfilePage enterCurrentPassword(String password) {
        WebElement currentPasswordField = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
        return this;
    }

    public ProfilePage openProfile() {
        WebElement profile = driver.findElement(By.cssSelector(".view-profile"));
        profile.click();
        return this;
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
