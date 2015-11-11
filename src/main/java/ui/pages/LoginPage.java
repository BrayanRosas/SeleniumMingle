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

    @FindBy(name = "commit")
    WebElement loginBtn;

    @FindBy(id="notice")
    WebElement loginNotice;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    public LoginPage setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPage setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtnFailed() {
        loginBtn.click();
        return this;
    }

    public String getNotice(){
        String notice =loginNotice.getText();
        return notice;
    }

    private void login(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
    }

    public LoginPage loginFailed(String userName, String password) {
        login(userName, password);
        return clickLoginBtnFailed();
    }
}

