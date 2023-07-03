package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutKoelPage extends BasePage{
    public AboutKoelPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   private By aboutKoelPage = By.cssSelector( "button[data-test='close-modal-btn']");
    public WebElement getAboutKoelPage() {return (findElement(aboutKoelPage));}
}
