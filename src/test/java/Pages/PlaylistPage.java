package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public PlaylistPage choosePlaylist() {
        WebElement chooseAnyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'yes')]")));
        chooseAnyPlaylist.click();
        return this;
    }

    public PlaylistPage createAnewPlaylistBtn() {
        WebElement clickPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.fa.fa-plus-circle.create")));
        clickPlaylistButton.click();
        return this;
    }

private By newPlaylistBtn = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    public WebElement getNewPlaylistBtn() {return (findElement(newPlaylistBtn));}

    private By newSmartPlaylistBtn = By.cssSelector("li[data-testid='playlist-context-menu-create-smart']");
    public WebElement getNewSmartPlaylistBtn() {return (findElement(newSmartPlaylistBtn));}

    private By favoritesBtn = By.cssSelector("a[href='#!/favorites']");
    public WebElement getFavoriteBtn() {return (findElement(favoritesBtn));}

    private By recentlyPlayed = By.cssSelector("li.playlist.recently-played");
    public WebElement getRecentlyPlayed() {return (findElement(recentlyPlayed));}

    private By displayedPlaylist = By.cssSelector("li.playlist.playlist a[href='#!/playlist/63134']");
    public WebElement getDisplayedPlaylist() {return(findElement(displayedPlaylist));}

    private By displayedSmartPlaylist = By.cssSelector(".playlist.playlist.smart");
    public WebElement getDisplayedSmartPlaylist() {return(findElement(displayedSmartPlaylist));}
}
