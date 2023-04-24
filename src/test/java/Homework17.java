import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Added 1 song into";

        navigateToPage();
        enterEmail("agnes.albertusiak@testpro.io");
        enterPassword("te$tStudent1");
        clickSubmit();
        searchSong("Epic Song");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));


    }

}
