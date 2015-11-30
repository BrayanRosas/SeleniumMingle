package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/10/15
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends BasePageObject{
    @FindBy(id = "user_login")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(id = "user_password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(xpath= "//input[@name='commit']")
    WebElement loginBtn;


    @FindBy(xpath = "//div[@id='error_explanation']/div")
    WebElement errorExplanationText;


    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    public void setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void loginButtonClick() {
        loginBtn.click();
    }

    public String getErrorLogin(){

        return errorExplanationText.getText();
    }


    public MainPage loginSuccess(String userName, String password) {
         setUserNameInput(userName);
         setPasswordInput(password);
         loginButtonClick();
         return new  MainPage();
    }

    public LoginPage loginFailed(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
        loginButtonClick() ;
        return this;
    }

}

