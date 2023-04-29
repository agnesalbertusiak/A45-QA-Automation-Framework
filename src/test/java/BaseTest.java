import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage() {
        String url= "http://bbb.testpro.io/";
        driver.get(url);
    }


    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void enterPassword(String te$tStudent1) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(te$tStudent1);
    }

    public void clickSubmit() throws InterruptedException{
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();


    }

    public void searchSong(String epicSong) throws InterruptedException{
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='q']")));
        searchField.sendKeys(epicSong);

    }
    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearch.click();
    }
    public void selectFirstSong() throws InterruptedException{
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        selectSong.click();
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to")));
        addToBtn.click();
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement chooseAnyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'yes')]")));
        chooseAnyPlaylist.click();
    }

    public String getNotificationText(){
        WebElement notificationT = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return notificationT.getText();
    }


}