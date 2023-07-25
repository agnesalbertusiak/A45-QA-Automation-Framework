import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePreferencesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePasswordTests extends BaseTest{

    @Test (priority = 1)

    public void userIsUnableToUpdatePasswordWith5Characters() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$d1");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());
    }
    @Test (priority = 2)
    public void userIsUnableToUpdatePasswordWith9Characters()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$t$tud1");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());
    }

    @Test (priority = 3)
    public void userIsAbleToUpdatePasswordWith10Characters()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$t$tud10");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test (priority = 4)
    public void userIsAbleToUpdatePasswordWith11Characters()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud10").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud10");
        profilePreferences.enterNewPassword("Te$t$tud101");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test (priority = 5)
    public void userIsAbleToUpdatePasswordWith14Characters()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud101").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud101");
        profilePreferences.enterNewPassword("Te$t$tud101234");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test (priority = 6)
    public void userIsAbleToUpdatePasswordWith15Characters()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud101234").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud101234");
        profilePreferences.enterNewPassword("Te$t$tud1012345");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test (priority = 7)
    public void userIsUnableToUpdatePasswordWith16Characters()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud1012345").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud1012345");
        profilePreferences.enterNewPassword("Te$t$tud10123456");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertFalse(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test (priority = 8)
    public void userGoesBackToHisOldPassword()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud10123456").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud10123456");
        profilePreferences.enterNewPassword("te$t$tudent1");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test (priority = 9)
    public void userIsNotAbleToUpdatePasswordWithoutLowercase()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("TORREVIEJA1@");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());

    }

    @Test (priority = 10)
    public void userIsNotAbleToUpdatePasswordWithoutUppercase()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("TORREVIEJA1@").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("TORREVIEJA1@");
        profilePreferences.enterNewPassword("torrevieja1@");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());

    }
    @Test (priority = 11)
    public void userIsNotAbleToUpdatePasswordWithoutSpecialCharacter()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("torrevieja1@").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("torrevieja1@");
        profilePreferences.enterNewPassword("Torrevieja1");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());

    }
    @Test (priority = 12)
    public void userGoesBackToHisOldPassword2()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("torrevieja1@").clickSubmit();
        Thread.sleep(2000);
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("torrevieja1@");
        profilePreferences.enterNewPassword("te$t$tudent1");
        Thread.sleep(2000);
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
}
