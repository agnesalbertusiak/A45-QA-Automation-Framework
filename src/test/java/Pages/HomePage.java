package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }
    By secondPlaylist = By.cssSelector(".playlist:nth-child(4)");
    By playlistNameField = By.cssSelector("[name='name']");

    public void doubleClickPlaylist() {doubleClick(secondPlaylist);}
    public void enterNewPlaylistName(String playlistName) {
    findElement(playlistNameField).sendKeys(playlistName);
    findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
    findElement(playlistNameField).sendKeys(playlistName);
    findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylistName = By.xpath("//a[text()='"+playlistName+"']");
        return findElement(newPlaylistName).isDisplayed();
    }
}
