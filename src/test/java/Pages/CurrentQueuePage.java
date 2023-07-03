package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrentQueuePage extends BasePage{
    public CurrentQueuePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By currentQueuePage = By.cssSelector("a[href='#!/queue']");
    public WebElement getCurrentQueuePage() {return findElement(currentQueuePage);}
}
