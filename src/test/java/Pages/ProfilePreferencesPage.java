package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePreferencesPage extends BasePage{
    public ProfilePreferencesPage(WebDriver givenDriver) {
        super(givenDriver);
    }


        @FindBy (css = "input[name='current_password']")
        private WebElement currentPasswordField;
    public ProfilePreferencesPage enterCurrentPassword(String password) {
        findElement(currentPasswordField) .sendKeys(password);
       return this;
    }

       @FindBy (css = "input#inputProfileNewPassword")
    private WebElement newPasswordField;


    protected WebElement findElement (WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }
    public ProfilePreferencesPage enterNewPassword(String password) {newPasswordField.sendKeys(password);
    return this;
    }
    private By profilePreferencesPage = By.cssSelector("form[data-testid='update-profile-form']");
    public WebElement getProfilePreferencesPage() {return findElement(profilePreferencesPage);}
}