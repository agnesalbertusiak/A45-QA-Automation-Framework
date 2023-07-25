import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {

    // @Test
    //public void addSongToPlaylist() throws InterruptedException {
    //   LoginPage loginPage = new LoginPage(getDriver());
    // HomePage homePage = new HomePage(getDriver());
    // PlaylistPage playlistPage = new PlaylistPage(getDriver());

    // String newSongAddedNotification = "Added 1 song into";

    // loginPage.login();
    //homePage.searchSong("Epic Song");
    // homePage.clickViewAllBtn();
    // homePage.selectFirstSong();
    //homePage.clickAddToBtn();
    //playlistPage.choosePlaylist();
    //Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));


    //}

    //@Test
    //public void renamePlaylist (){
    //String newPlaylistName = "SummerVibes";
    // LoginPage loginPage = new LoginPage(getDriver());
    //HomePage homePage = new HomePage(getDriver());

    //loginPage.login();
    //homePage.doubleClickPlaylist();
    // homePage.enterNewPlaylistName(newPlaylistName);
    // Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));

    //}
    @Test
    public void createPlaylist () {

        String newPlaylistName = "Vacation";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));

    }

    @Test
    public void userCantCreateAPlaylistWithTheSameName () {
        String newPlaylistName = "Vacation";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertFalse(playlistPage.getSuccessShowMsg().isDisplayed());
    }
    @Test
    public void UserIsUnableToCreatePlaylistWith2Characters () {
        String newPlaylistName = "Va";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertFalse(playlistPage.getSuccessShowMsg().isDisplayed());
    }

    @Test
    public void UserIsAbleToCreatePlaylistWith3Characters () {
        String newPlaylistName = "Var";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(playlistPage.getSuccessShowMsg().isDisplayed());
    }
    @Test
    public void UserIsAbleToCreatePlaylistWith5Characters () {
        String newPlaylistName = "Varso";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(playlistPage.getSuccessShowMsg().isDisplayed());
    }
    @Test
    public void UserIsAbleToCreatePlaylistWith10Characters () {
        String newPlaylistName = "Varsovia23";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(playlistPage.getSuccessShowMsg().isDisplayed());
    }
    @Test
    public void UserIsUnableToCreatePlaylistWith11Characters () {
        String newPlaylistName = "Varsovia011";
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        playlistPage.createAnewPlaylistBtn();
        playlistPage.clickNewPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertFalse(playlistPage.getSuccessShowMsg().isDisplayed());
    }

}
