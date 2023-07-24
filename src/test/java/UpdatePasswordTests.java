import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePreferencesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePasswordTests extends BaseTest{

    @Test

    public void userIsUnableToUpdatePasswordWith5Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$d1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());
    }
    @Test
    public void userIsUnableToUpdatePasswordWith9Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$t$tud1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());
    }

    @Test
    public void userIsAbleToUpdatePasswordWith10Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$t$tud10");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test
    public void userIsAbleToUpdatePasswordWith11Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud10").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud10");
        profilePreferences.enterNewPassword("Te$t$tud101");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test
    public void userIsAbleToUpdatePasswordWith14Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud101").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud101");
        profilePreferences.enterNewPassword("Te$t$tud101234");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test
    public void userIsAbleToUpdatePasswordWith15Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud101234").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud101234");
        profilePreferences.enterNewPassword("Te$t$tud1012345");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test
    public void userIsUnableToUpdatePasswordWith16Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud1012345").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud1012345");
        profilePreferences.enterNewPassword("Te$t$tud10123456");
        homePage.clickSave();

        Assert.assertFalse(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test
    public void userGoesBackToHisOldPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("Te$t$tud10123456").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud10123456");
        profilePreferences.enterNewPassword("te$t$tudent1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
    @Test
    public void userIsNotAbleToUpdatePasswordWithoutLowercase(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent1").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("TORREVIEJA1@");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());

    }

    @Test
    public void userIsNotAbleToUpdatePasswordWithoutUppercase(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("TORREVIEJA1@").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("TORREVIEJA1@");
        profilePreferences.enterNewPassword("torrevieja1@");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());

    }
    @Test
    public void userIsNotAbleToUpdatePasswordWithoutSpecialCharacter(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("torrevieja1@").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("torrevieja1@");
        profilePreferences.enterNewPassword("Torrevieja1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileErrorMsg().isDisplayed());

    }
    @Test
    public void userGoesBackToHisOldPassword2() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("agne23@gmail.com").enterPassword("torrevieja1@").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("torrevieja1@");
        profilePreferences.enterNewPassword("te$t$tudent1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().isDisplayed());
    }
}
