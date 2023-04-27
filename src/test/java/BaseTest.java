import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    public static String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void openBrowser(String BaseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        driver.get(url);

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


    public void login(String mail, String te$tStudent1) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(mail);

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(te$tStudent1);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public void openPlaylist() {
        WebElement openExistingPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        openExistingPlaylist.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();

    }

    public String getDeletedPlaylistMessage() {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMessage.getText();
    }
}