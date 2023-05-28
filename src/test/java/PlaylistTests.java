import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        String newSongAddedNotification = "Added 1 song into";

        loginPage.login();
        homePage.searchSong("Epic Song");
        homePage.clickViewAllBtn();
        homePage.selectFirstSong();
        homePage.clickAddToBtn();
        playlistPage.choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));


    }

    @Test
    public void renamePlaylist (){
        String newPlaylistName = "SummerVibes";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));

    }
}
