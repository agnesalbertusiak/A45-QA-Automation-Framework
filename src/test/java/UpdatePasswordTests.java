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
        String profileUpdatedMsg = "The new password must be at least 10 characters.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent");
        profilePreferences.enterNewPassword("Te$d1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }
    @Test
    public void userIsUnableToUpdatePasswordWith9Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String profileUpdatedMsg = "The new password must be at least 10 characters.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$t$tud1");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }

    @Test
    public void userIsAbleToUpdatePasswordWith10Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent1");
        profilePreferences.enterNewPassword("Te$t$tud10");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }
    @Test
    public void userIsAbleToUpdatePasswordWith11Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("te$t$tudent");
        profilePreferences.enterNewPassword("Te$t$tud101");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }
    @Test
    public void userIsAbleToUpdatePasswordWith14Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud101");
        profilePreferences.enterNewPassword("Te$t$tud101234");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }
    @Test
    public void userIsAbleToUpdatePasswordWith15Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud101234");
        profilePreferences.enterNewPassword("Te$t$tud1012345");
        homePage.clickSave();

        Assert.assertTrue(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }
    @Test
    public void userIsUnableToUpdatePasswordWith16Characters(){
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePreferencesPage profilePreferences = new ProfilePreferencesPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String profileUpdatedMsg = "Profile updated.";

        loginPage.enterEmail("agne23@gmail.com").enterPassword("te$t$tudent").clickSubmit();
        homePage.clickEditUserProfile();
        profilePreferences.enterCurrentPassword("Te$t$tud1012345");
        profilePreferences.enterNewPassword("Te$t$tud10123456");
        homePage.clickSave();

        Assert.assertFalse(homePage.getProfileUpdatedMsg().contains(profileUpdatedMsg));
    }
}
