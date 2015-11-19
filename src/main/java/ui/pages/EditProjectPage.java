package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/16/15
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditProjectPage extends BasePageObject {

     /*
     Inputs of Edit pege
      */
    @FindBy(id ="project_name")
    WebElement projectNameInput;

    @FindBy(id ="project_identifier")
    WebElement projectIdentifierInput;

    @FindBy(id ="project_description")
    WebElement projectDescriptionInput;

     /*
     Buttons and links
      */
     @FindBy(xpath ="//a[contains(@href, '/admin/projects/delete')]")
     WebElement projectDeleteButton;

    @FindBy(linkText = "Cancel")
    WebElement projectCancelButton;

    @FindBy(linkText = "Save")
    WebElement projectSaveButton;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(projectDeleteButton));
    }



}
