import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{
    @Test
    public void newUserRegistrationSuccesfull() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.clickRegistration();
        loginPage.enterEmail("darek67@gmail.com");
        loginPage.clickRegisterBtn();

        Assert.assertTrue(homePage.showRegistrationSucc().isDisplayed());


    }

    @Test
    public void verifyWelcomeMessageForNewUser(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("darek67@gmail.com").enterPassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(homePage.getWelcomeMessageText(), "Hello, Student!");

    }

    @Test void recentlyPlayedSongListEmptyIfNoSongsPlayed () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("darek67@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickHomepagePanel();
        Assert.assertTrue(homePage.getRecentlyPlayedSongPanelEmpty().isDisplayed());
    }
    @Test
    public void recentlyPlayedSongsDisplayed() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.clickSong().doubleClickFirstSong().clickHomepagePanel();

        Assert.assertTrue(homePage.getRecentlyPlayedSongs().isDisplayed());

    }

    @Test
    public void viewAllButtonDisplayed() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getViewAllBtn().isDisplayed());
    }
    @Test
    public void recentlyAddedSongsAreDisplayed () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getRecentlyAddedSongs().isDisplayed());
    }
    @Test
    public void recentlyAddedAlbumsAreDisplayed () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getRecentlyAddedAlbums().isDisplayed());

    }
    @Test
    public void downloadIconDisplayedForRecentlyAddedSongs() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        basePage.hoverFirstSong();
        Assert.assertTrue(homePage.getDownloadIcon().isDisplayed());


    }
    @Test
    public void shuffleIconDisplayedForRecentlyAddedSongs() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        basePage.hoverFirstSong();
        Assert.assertTrue(homePage.getShuffleIcon().isDisplayed());
    }

    @Test
    public void searchFieldIsPresent () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getSearchField().isDisplayed());
    }

    @Test
    public void userIsAbleToSearchAsong () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.searchSong("Epic Song");
        Assert.assertTrue(homePage.getSearchField().isDisplayed());
    }
    @Test
    public void yourMusicPanelIncludesHomePage(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getHomePage().isDisplayed());
    }
    @Test
    public void yourMusicPanelIncludesCurrentQueuePage(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CurrentQueuePage currentQueue = new CurrentQueuePage(getDriver());

        loginPage.login();
        Assert.assertTrue(currentQueue.getCurrentQueuePage().isDisplayed());
    }
    @Test
    public void yourMusicPanelIncludesCurrentAllSongsPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongs = new AllSongsPage(getDriver());

        loginPage.login();
        Assert.assertTrue(allSongs.getAllSongsPage().isDisplayed());
    }
    @Test
    public void yourMusicPanelIncludesAlbumPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AlbumsPage albumsPage = new AlbumsPage(getDriver());

        loginPage.login();
        Assert.assertTrue(albumsPage.getAlbumsPage().isDisplayed());
    }
    @Test
    public void yourMusicPanelIncludesArtistPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ArtistsPage albumsPage = new ArtistsPage(getDriver());

        loginPage.login();
        Assert.assertTrue(albumsPage.getArtistsPage().isDisplayed());
    }

    @Test
    public void newPlaylistButtonIsDisplayed() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        Assert.assertTrue(playlistPage.getNewPlaylistBtn().isDisplayed());
    }
    @Test
    public void newSmartPlaylistButtonIsDisplayed() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        Assert.assertTrue(playlistPage.getNewSmartPlaylistBtn().isDisplayed());
    }
  @Test
    public void profileIconIsDisplayedAndUserIsRedirectedToProfilePreferencesPage() {
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(getDriver());

      loginPage.login();
      homePage.getUserAvatar().click();
      Assert.assertTrue(profilePreferencesPage.getProfilePreferencesPage().isDisplayed());
  }
  @Test
    public void logoutIconIsPresentAndUserIsRedirectedToLoginPage() {
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      String home= "https://qa.koel.app/#!/home";
      loginPage.login();
      homePage.logout();
      Assert.assertEquals(getDriver().getCurrentUrl(), home);


  }

  @Test
    public void aboutKoelIconPresentAndRedirectedToAboutKoelPage(){
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      AboutKoelPage aboutKoelPage = new AboutKoelPage(getDriver());

      loginPage.login();
      homePage.aboutKoel();

      Assert.assertTrue(aboutKoelPage.getAboutKoelPage().isDisplayed());
  }
  @Test
    public void playlistPanelIncludesFavorites(){
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      PlaylistPage playlistPage = new PlaylistPage(getDriver());

      loginPage.login();

      Assert.assertTrue(playlistPage.getFavoriteBtn().isDisplayed());
  }
  @Test
  public void playlistPanelIncludesRecentlyPlayed(){
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      PlaylistPage playlistPage = new PlaylistPage(getDriver());

      loginPage.login();
      Assert.assertTrue(playlistPage.getRecentlyPlayed().isDisplayed());
  }
  @Test
    public void playlistPanelIncludesAddedPlaylist(){
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      PlaylistPage playlistPage = new PlaylistPage(getDriver());

      loginPage.login();
      Assert.assertTrue(playlistPage.getDisplayedPlaylist().isDisplayed());
  }
  @Test
    public void playedPanelIncludesCreatedSmartPlaylist(){
      LoginPage loginPage = new LoginPage(getDriver());
      HomePage homePage = new HomePage(getDriver());
      PlaylistPage playlistPage = new PlaylistPage(getDriver());

      loginPage.login();
      Assert.assertTrue(playlistPage.getDisplayedSmartPlaylist().isDisplayed());
  }
}
