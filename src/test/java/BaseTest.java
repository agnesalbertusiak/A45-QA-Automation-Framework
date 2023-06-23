import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

   // WebDriver driver; duplicate driver declaration
    WebDriverWait wait;

    Actions actions = null;
    public static ThreadLocal<WebDriver> threadDriver = null;
public static String url = null;
public static WebDriver driver;


    @BeforeSuite
    static void setupClass() {
       // WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void openBrowser(String BaseURL) throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);we need to remove or comment this, since we will use the browser factory pickBrowser()
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);


        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        actions = new Actions(getDriver());
        url = BaseURL;
        getDriver().get(url);
        navigateToPage();

        }
    private WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        String gridURL = "http://10.0.0.105:4444/";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-firefox":
                //changed capabilityName from browser to browserName
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            //changed capabilityName from browser to browserName
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "lambda":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

public static WebDriver lambdaTest () throws MalformedURLException {
    String hubURL = "https://@hub.lambdatest.com/wd/hub";

     String username =  "agnes.albertusiak";
    String accessTocen = "vJ95q87Z8jOrZhj5P82UsnvTzM2mdHbhcA70wSx9HNY8ZcBUnM";


    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("114.0");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", "agnes.albertusiak");
    ltOptions.put("accessKey", "vJ95q87Z8jOrZhj5P82UsnvTzM2mdHbhcA70wSx9HNY8ZcBUnM");
    ltOptions.put("project", "Untitled");
    ltOptions.put("w3c", true);
    ltOptions.put("plugin", "java-testNG");
    browserOptions.setCapability("LT:Options", ltOptions);

    return new RemoteWebDriver(new URL(hubURL), browserOptions);
}
    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
        threadDriver.remove();

    }
    public WebDriver getDriver (){
        return threadDriver.get();
    }

    public void navigateToPage() {
        String url= "https://qa.koel.app/";
        getDriver().get(url);

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

    public void clickSubmit(){
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();


    }

    public void searchSong(String epicSong) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='q']")));
        searchField.sendKeys(epicSong);

    }
    public void clickViewAllBtn() {
        WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearch.click();
    }
    public void selectFirstSong() {
        WebElement selectSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        selectSong.click();
    }

    public void clickAddToBtn(){
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to")));
        addToBtn.click();
    }

    public void choosePlaylist() {
        WebElement chooseAnyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'yes')]")));
        chooseAnyPlaylist.click();
    }

    public String getNotificationText(){
        WebElement notificationT = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return notificationT.getText();
    }


}