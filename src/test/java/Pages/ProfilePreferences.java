package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePreferences extends BasePage{
    public ProfilePreferences (WebDriver givenDriver) {
        super(givenDriver);
    }


        @FindBy (css = "input[name='current_password']")
        private WebElement currentPasswordField;
    public void enterCurrentPassword(String password) {currentPasswordField.sendKeys(password);}

       @FindBy (css = "input#inputProfileNewPassword")
    private WebElement newPasswordField;

    public void enterNewPassword(String password) {newPasswordField.sendKeys(password);}
}
