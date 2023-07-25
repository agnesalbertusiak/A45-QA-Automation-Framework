package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver givenDriver) {
        super (givenDriver);
    }


    @FindBy (css = "[type='email']")
    private WebElement emailField;
    @FindBy (css = "[type='password']" )
    private WebElement passwordField;
    @FindBy (css = "button[type='submit']" )
    private WebElement submitBtn;
   //private By emailField = By.cssSelector("[type='email']");
   //private  By passwordField = By.cssSelector("[type='password']");
    // private By submitBtn = By.cssSelector("button[type='submit']");


    public LoginPage enterEmail (String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }
    public LoginPage login() {
        enterEmail("agnes.albertusiak@testpro.io");
        enterPassword("te$t$tudent1");
        clickSubmit();
        return this;
    }
    public LoginPage clickRegistration() {
        WebElement registration = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[type='submit']")));
        registration.click();
        return this;
    }

    public LoginPage clickRegisterBtn() {
        WebElement registrationBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='button']")));
        registrationBtn.click();
        return this;
    }
    public String getEmailFieldNotificationMessage(){
        String validationMessage = emailField.getAttribute("validationMessage");
        return validationMessage;
    }

    public String getPasswordFieldNotificationMessage(){
        String validationMessage = passwordField.getAttribute("validationMessage");
        return validationMessage;
    }
}
