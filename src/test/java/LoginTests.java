import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePreferencesPage;
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

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test
    public void loginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes230ska@gmail.com");
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
        loginPage.enterEmail("dare09@gmail.com");
        loginPage.clickRegisterBtn();

        Assert.assertTrue(homePage.showRegistrationSucc().isDisplayed());
    }

    @Test
    public void userChangesEmail() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());

        loginPage.login();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        loginPage.enterEmail("aska20@gmail.com");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }

    @Test
    public void loginWithUpdatedEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());

        loginPage.enterEmail("aska20@gmail.com");
        loginPage.enterPassword("te$t$tudent1");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void unsuccesfullLoginWithOldEmail() {
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
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());

        loginPage.enterEmail("aska20@gmail.com");
        loginPage.enterPassword("te$t$tudent1");
        loginPage.clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("te$t$tudent14");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }

    @Test
    public void userGoesBackToHisOldEmailAndPassword() throws InterruptedException {
        String profileUpdatedMsg = "Profile updated.";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());

        loginPage.enterEmail("aska20@gmail.com");
        loginPage.enterPassword("te$t$tudent14");
        loginPage.clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent14");
        loginPage.enterEmail("agnes.albertusiak@testpro.io");
        profilePreferences.enterNewPassword("te$t$tudent1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }

    @Test
    public void userCannotLoginWithInvalidEmailFormat() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("@testpro.io");
        loginPage.enterPassword("te$t$tudent1");
        loginPage.clickSubmit();

        Assert.assertEquals(loginPage.getEmailFieldNotificationMessage(), "email format is incorrect");
    }

    @Test
    public void loginInvalidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail("agnes.albertusiak@testpro.io");
        loginPage.enterPassword("te$tstudent12");
        loginPage.clickSubmit();

        Assert.assertEquals(loginPage.getPasswordFieldNotificationMessage(), "Password is incorrect");
    }
}


