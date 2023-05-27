package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By secondPlaylist = By.cssSelector(".playlist:nth-child(4)");
    private By playlistNameField = By.cssSelector("[name='name']");

    public void doubleClickPlaylist() {
        doubleClick(secondPlaylist);
    }

    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylistName = By.xpath("//a[text()='" + playlistName + "']");
        return findElement(newPlaylistName).isDisplayed();
    }

    public void searchSong(String epicSong) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='q']")));
        searchField.sendKeys(epicSong);

    }

    public void clickViewAllBtn() {
        WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearch.click();
    }

    public void selectFirstSong() {
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        selectSong.click();
    }
    public void clickAddToBtn(){
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to")));
        addToBtn.click();
    }
}

