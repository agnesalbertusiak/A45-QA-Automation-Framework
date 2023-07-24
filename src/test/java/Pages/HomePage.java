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

    private By registrationSuccesfull = By.cssSelector("a[alt='Home page link']");

    private By isRecentlyPlayedSongDisplayed = By.cssSelector(".recent-song-list");

    private By firstSong = By.cssSelector("section#albumWrapper tr.song-item td.title");

    private By recentlyPlayedSongPanelEmpty = By.cssSelector("section.recent");
    private By recentlyAddedSongs = By.cssSelector(".recently-added-song-list");
    private By recentlyAddedAlbums = By.cssSelector(".recently-added-album-list");

    private By searchField = By.cssSelector("[name='q']");

    private By viewAllBtn = By.cssSelector("section#homeWrapper h1 button");

    private By songResults = By.cssSelector("section.songs");

    private By downoladIcon = By.cssSelector("ol.recently-added-album-list a[title='Download all songs in the album Dark Days EP']");
    private By shuuffleIcon = By.cssSelector("ol.recently-added-album-list a[title='Shuffle all songs in the album Dark Days EP']");

    private By homePage = By.cssSelector("a[href='#!/home']");


    private By albumsPage = By.cssSelector("a[href='#!/albums']");
    private By artistsPage = By.cssSelector("a[href='#!/artists']");

    public WebElement getHomePage () {
        return findElement(homePage);
    }

    public WebElement getSearchField () {
        return findElement(searchField);
    }

    public WebElement getSongResults () {
        return findElement(songResults);
        }

        public WebElement getDownloadIcon () {return findElement(downoladIcon);}
    public WebElement getShuffleIcon () {return findElement(shuuffleIcon);}
    public WebElement getRecentlyPlayedSongs () {
        return findElement(isRecentlyPlayedSongDisplayed);
    }
    public WebElement getRecentlyAddedSongs () {
        return findElement(recentlyAddedSongs);
    }
    public WebElement getRecentlyAddedAlbums () {
        return findElement(recentlyAddedAlbums);
    }
    public WebElement getViewAllBtn () {
        return findElement(viewAllBtn);
    }
    public WebElement getRecentlyPlayedSongPanelEmpty () {
        return findElement(recentlyPlayedSongPanelEmpty);
    }

    public WebElement showRegistrationSucc () {
        return findElement(registrationSuccesfull);
    }


    private By notificationMsg = By.cssSelector("div.success.show");
    public WebElement getProfileUpdatedMsg() {return findElement(notificationMsg);}
    private By errorMsg = By.cssSelector("div.error.show");

    public WebElement getProfileErrorMsg() {return findElement(errorMsg);}

    private By userAvatar = By.cssSelector("img.avatar");
    public WebElement getUserAvatar () {
        return findElement(userAvatar);
    }

    private By welcomeText = By.cssSelector("#homeWrapper header h1");
    public WebElement welcomeMessage () {return findElement(welcomeText);}

    public String getWelcomeMessageText(){
        String validationMessage = welcomeMessage().getAttribute("validationMessage");
        return validationMessage;
    }

    public HomePage doubleClickPlaylist() {
        doubleClick(secondPlaylist);
        return this;
    }

    public HomePage doubleClickFirstSong() {
        doubleClick(firstSong);
        return this;
    }
    public HomePage enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylistName = By.xpath("//a[text()='" + playlistName + "']");
        return findElement(newPlaylistName).isDisplayed();
    }

    public HomePage searchSong(String epicSong) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='q']")));
        searchField.sendKeys(epicSong);
        return this;

    }

    public HomePage clickViewAllBtn() {
        WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearch.click();
        return this;
    }

    public HomePage selectFirstSong() {
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        selectSong.click();
        return this;
    }

    public HomePage firstSong() {
        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#albumWrapper  tr.song-item td.title")));
        clickSong.click();
        return this;
    }
    public HomePage clickAddToBtn(){
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to")));
        addToBtn.click();
        return this;
    }

    public HomePage clickSave() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveBtn.click();
        return this;
    }
    public HomePage aboutKoel(){
        WebElement aboutKoelBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.about.control")));
        aboutKoelBtn.click();
        return this;
    }
    public HomePage logout(){
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".logout.control")));
        logoutBtn.click();
        return this;


    }
    public HomePage clickEditUserProfile() {
        WebElement userProfile = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View/edit user profile']")));
        userProfile.click();
        return this;
    }
    public HomePage clickSong() {
        WebElement clickOnSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ol[@class='recently-added-album-list']//a[@href='#!/album/20']")));
        clickOnSong.click();
        return this;
    }
    public HomePage clickHomepagePanel() {
        WebElement homePagePanel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/home']")));
        homePagePanel.click();
        return this;
    }
        public HomePage clickPlayButton (){
            WebElement playNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-next-btn']")));
            WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
            playButton.click();
            playButton.click();
            return this;

        }
    }


