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
 * Date: 11/12/15
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewProjectPage extends BasePageObject {

    @FindBy(id ="project_name")
    @CacheLookup
    WebElement projectNameInput;
    //hard code
    @FindBy(xpath ="//img[@alt='Scrum']")
    @CacheLookup
    WebElement templateProject;

    @FindBy(id ="options-toggle-link")
    WebElement advanceProjectList;

    @FindBy(id ="project_time_zone")
    WebElement timezoneProjectInput;

    @FindBy(id ="project_date_format")
    WebElement dateFormatProjectInput;

    @FindBy(id ="project_exclude_weekends_in_cta")
    WebElement excludeWeekendsProjectSelector;

    @FindBy(id ="project_precision")
    WebElement precisionProjectInput;

    @FindBy(id ="project_membership_requestable")
    WebElement membershipRequestableProjectSelector;

    @FindBy(id="enable_auto_enroll")
    WebElement enableAutoEnrollProjectSelector;

    @FindBy(id="project_icon")
    WebElement iconProjectInput;

    @FindBy(id="create_project")
    WebElement createProjectButton;




    public NewProjectPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createProjectButton));
    }

    public NewProjectPage setProjectDetails (String projectName) {
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
        templateProject.click();
        return this;
    }

    public NewProjectPage setAdvancedProjectDetails(String timezone,String formatDate,String precision,String imagePath){
        advanceProjectList.click();
        timezoneProjectInput.sendKeys(timezone);
        dateFormatProjectInput.sendKeys(formatDate);
        excludeWeekendsProjectSelector.click();
        precisionProjectInput.clear();
        precisionProjectInput.sendKeys(precision);
        membershipRequestableProjectSelector.click();
        enableAutoEnrollProjectSelector.click();
        iconProjectInput.sendKeys(imagePath);

        return this;
    }

    public WebElement clickCreateProject(){
        createProjectButton.click();
        return createProjectButton;
    }


}
