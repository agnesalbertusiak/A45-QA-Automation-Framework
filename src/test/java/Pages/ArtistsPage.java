package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArtistsPage extends BasePage{
    public ArtistsPage(WebDriver givenDriver) {super(givenDriver);}
        private By artistsPage = By.cssSelector("a[href='#!/artists']");
        public WebElement getArtistsPage() {return (findElement(artistsPage)); }
    }
