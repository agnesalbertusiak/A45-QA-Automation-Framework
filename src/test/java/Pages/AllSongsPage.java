package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By allSongsPage = By.cssSelector("a[href='#!/songs']");
    public WebElement getAllSongsPage() {return (findElement(allSongsPage)); }
}
