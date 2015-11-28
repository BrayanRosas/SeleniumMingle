package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.BasePageProject;
import ui.PageTransporter;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/27/15
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class BottomBar extends BasePageObject {

    @FindBy(id = "ft")
    WebElement supportPanel;

    @FindBy(id = "magic_card")
    WebElement newCardLink;

    @FindBy(css = "button.show-form")
    WebElement deployInviteFormButton;

    @FindBy(id = "email")
    WebElement emailInput;   //is inside of the inviteForm

    @FindBy(xpath = "//div[@id='ft']/div[2]/form/button")
    WebElement cancelButton;   //is inside of the inviteForm

    @FindBy(xpath = "//input[@name='invite-to-team']")
    WebElement inviteButton;   //is inside of the inviteForm

    public BottomBar() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(deployInviteFormButton));
    }

    public BasePageProject inviteUser(String email){
        //wait.until(ExpectedConditions.visibilityOf(deployInviteFormButton));
        deployInviteFormButton.click();
        emailInput.sendKeys(email);
        inviteButton.click();
        return new BasePageProject();
    }



}
