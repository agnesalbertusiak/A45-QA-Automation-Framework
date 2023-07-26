import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesTests extends BaseTest {

    @Test
    public void favoritesPlaylistIsEmptyIfNoSongsPlayed (){
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        playlistPage.getFavoriteBtn().click();
        Assert.assertTrue(playlistPage.notFavoritesYet().isDisplayed());
    }

    @Test
    public void favoritesPlaylistContainsAllSongsSavedAsFavorite(){

        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login();
        allSongsPage.hoverFirstSong();
        basePage.clickLikeBtn();
        homePage.searchSong("Dark Days").clickViewAllBtn().selectFirstSong().clickLikeUnlike();
        Assert.assertTrue(playlistPage.secondSongIsDisplayed().isDisplayed());
        Assert.assertTrue(playlistPage.firstSongIsDisplayed().isDisplayed());

    }
    @Test

    public void userIsAbleToDownloadASong(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.searchSong("Lobo").clickViewAllBtn().rightClickFirstSong().clickDownload();
    }
}
