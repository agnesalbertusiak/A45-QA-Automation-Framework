package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By allSongsPage = By.cssSelector("a[href='#!/songs']");
    public WebElement getAllSongsPage() {return (findElement(allSongsPage)); }


    public AllSongsPage clickAllSongsPage() {
        WebElement clickAllSongsP = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/songs']")));
        clickAllSongsP.click();
        return this;
    }
    public AllSongsPage clickSong() {
        WebElement clickOnASong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td [contains (text(), 'Ketsa - Beautiful')]")));
        clickOnASong.click();
        return this;
    }
}
