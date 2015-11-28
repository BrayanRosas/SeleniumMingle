package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/26/15
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteProjectPage extends BasePageObject {

    @FindBy(id="confirm_bottom")
    WebElement deleteConfirmButton;

    @FindBy(xpath="//input[@name='projectName']")
    WebElement projectNameInput;

    @FindBy(xpath="//input[@value='I understand the consequences, delete this project']")
    WebElement submitDeleteButton;


    public DeleteProjectPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(deleteConfirmButton));

    }

    public MainPage confirmDeleteProject(String projectName){

        deleteConfirmButton.click();
        projectNameInput.sendKeys(projectName);
        submitDeleteButton.click();
        return new MainPage();

    }
}