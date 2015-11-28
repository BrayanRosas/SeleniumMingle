package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;


/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/21/15
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Header extends BasePageObject {
    @FindBy(xpath = "//img[@alt='Logo']")
    WebElement mingleLogo;

    @FindBy(xpath ="//li[@id='current-user']/a/span")
    WebElement userProfileLink;

    @FindBy(xpath="//a[contains(@href,'/profile/logout')]")
    WebElement logOutButton;

    public Header(){
       PageFactory.initElements(driver, this);
       waitUntilPageObjectIsLoaded();
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logOutButton));
    }

    public MainPage mingleLogoClick(){


            mingleLogo.click();
            return new MainPage();
    }
    public LoginPage singOutPage(){
        logOutButton.click();
        return new LoginPage();
    }

    public void userProfileClick(){
        userProfileLink.click();
    }

    public WebElement  getSingOut(){
            return logOutButton;
    }

}
