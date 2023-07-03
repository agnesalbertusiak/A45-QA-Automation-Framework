package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePreferencesPage extends BasePage{
    public ProfilePreferencesPage(WebDriver givenDriver) {
        super(givenDriver);
    }


        @FindBy (css = "input[name='current_password']")
        private WebElement currentPasswordField;
    public ProfilePreferencesPage enterCurrentPassword(String password) {currentPasswordField.sendKeys(password);
        return this;
    }

       @FindBy (css = "input#inputProfileNewPassword")
    private WebElement newPasswordField;

    public ProfilePreferencesPage enterNewPassword(String password) {newPasswordField.sendKeys(password);
    return this;
    }
    private By profilePreferencesPage = By.cssSelector("form[data-testid='update-profile-form']");
    public WebElement getProfilePreferencesPage() {return findElement(profilePreferencesPage);}
}