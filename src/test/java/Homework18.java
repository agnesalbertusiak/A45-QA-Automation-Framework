import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login ("agnes.albertusiak@testpro.io",  "te$tStudent1");
        playSongBtn();
        Assert.assertTrue(isSongPlaying());
    }
}
