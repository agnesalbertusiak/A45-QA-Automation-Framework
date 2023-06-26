import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePreferences;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void loginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes23ska@gmail.com");
        loginPage.enterPassword("te$tstudent1");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test
    public void succesfullLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@testpro.io");
        loginPage.enterPassword("te$t$tudent1");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginEmptyLoginEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void newUserRegistrationSuccesfull() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.clickRegistration();
        loginPage.enterEmail("darek25@gmail.com");
        loginPage.clickRegisterBtn();

        Assert.assertTrue(homePage.showRegistrationSucc().isDisplayed());
    }

    @Test
    public void userChangesEmail() throws InterruptedException {

        String profileUpdatedMsg = "Profile updated.";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        loginPage.login();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        loginPage.enterEmail("aska237@gmail.com");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }

    @Test
    public void loginWithUpdatedEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        loginPage.enterEmail("aska237@gmail.com");
        loginPage.enterPassword("te$t$tudent1");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void unsuccesfullLoginWithOldEmail(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@testpro.io");
        loginPage.enterPassword("te$t$tudent1");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void userChangesPassword() throws InterruptedException {

        String profileUpdatedMsg = "Profile updated.";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        loginPage.enterEmail("aska237@gmail.com");
        loginPage.enterPassword("te$t$tudent2");
        loginPage.clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent2");
        profilePreferences.enterNewPassword("te$t$tudent15");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));}

    @Test
    public void userGoesBackToHisOldEmailAndPassword() throws InterruptedException {
        String profileUpdatedMsg = "Profile updated.";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferences profilePreferences = new ProfilePreferences(getDriver());

        loginPage.enterEmail("aska237@gmail.com");
        loginPage.enterPassword("te$t$tudent15");
        loginPage.clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent15");
        loginPage.enterEmail("agnes.albertusiak@testpro.io");
        profilePreferences.enterNewPassword("te$t$tudent1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));}

    }


