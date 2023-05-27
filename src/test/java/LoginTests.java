import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
//    @Test
//    public void LoginEmptyEmailPasswordTest() {
//
////      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
//    }
    @Test
    public void loginValidEmailEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());

      loginPage.enterEmail("demo@class.com");
      loginPage.enterPassword("");
      loginPage.clickSubmit();

      Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://bbb.testpro.io/
    }
    public void loginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes23ska@gmail.com");
        loginPage.enterPassword("te$tstudent1");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://bbb.testpro.io/
    }
}
