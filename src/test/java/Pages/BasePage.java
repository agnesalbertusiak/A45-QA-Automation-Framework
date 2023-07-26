package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

   protected WebDriver driver;
    protected WebDriverWait wait;

    protected Actions actions;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
protected WebElement findElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
protected void doubleClick (By locator){
        actions.doubleClick(findElement(locator)).perform();
}
    public BasePage clickLikeBtn() {
        WebElement clickLikeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa.fa-heart-o")));
        clickLikeButton.click();
        return this;
    }

public WebElement hoverFirstSong () {
        WebElement hover1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ol[@class='recently-added-album-list']//a[@href='#!/album/20']")));
        actions.moveToElement(hover1).perform();
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ol[@class='recently-added-album-list']//a[@href='#!/album/20']")));
}
}
