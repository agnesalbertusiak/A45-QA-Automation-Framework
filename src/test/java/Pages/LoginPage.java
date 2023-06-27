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


    public void enterEmail (String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword (String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
    }
    public void login() {
        enterEmail("agnes.albertusiak@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    public void clickRegistration() {
        WebElement registration = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[type='submit']")));
        registration.click();
    }

    public void clickRegisterBtn() {
        WebElement registrationBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='button']")));
        registrationBtn.click();
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
