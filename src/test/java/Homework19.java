import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
    String deletedPlaylistMessage = "Deleted playlist";


    login("agnes.albertusiak@testpro.io", "te$tStudent1");
    openPlaylist();
    clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMessage().contains(deletedPlaylistMessage));
    }

}
