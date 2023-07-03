package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlbumsPage extends BasePage{
    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By albumPage = By.cssSelector("a[href='#!/albums']");
    public WebElement getAlbumsPage() {return (findElement(albumPage)); }
}
