import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void enterPassword(String te$tStudent1) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(te$tStudent1);
    }

    public void clickSubmit() throws InterruptedException{
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(5000);

    }

    public void searchSong(String epicSong) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        searchField.sendKeys(epicSong);
        Thread.sleep(5000);
    }
    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllSearch = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearch.click();
        Thread.sleep(5000);
    }
    public void selectFirstSong() throws InterruptedException{
        WebElement selectSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        selectSong.click();
        Thread.sleep(5000);
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(5000);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement chooseAnyPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'yes')]"));
        chooseAnyPlaylist.click();
        Thread.sleep(5000);
    }

    public String getNotificationText(){
        WebElement notificationT = driver.findElement(By.cssSelector("div.success.show"));
        return notificationT.getText();
    }


}