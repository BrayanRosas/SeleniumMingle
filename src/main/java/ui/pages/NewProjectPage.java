package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.BasePageProject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/12/15
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewProjectPage extends BasePageObject {

    Header header=new Header();

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

    @FindBy(id="notice")
    WebElement noticeNewProject;

    //
    @FindBy(id="project-list")
    WebElement projectListLink;



    //For verify the template create according with  Methodology
    @FindBy(id="tab_story_map_link")
    WebElement  storyMapLink;

    @FindBy(id="tab_product_backlog_link")
    WebElement backlogLink;

    @FindBy(id="tab_release_planning_link")
    WebElement releaseLink;

    @FindBy(id="tab_estimation_link")
    WebElement estimationLink;

    @FindBy(id="tab_sprint_board_link")
    WebElement sprintBoardLink;

    @FindBy(id="tab_retrospectives_link")
    WebElement retrospectiveLink;


    //to delete project
    @FindBy(id="tab_project_admin_link")
    WebElement projectAdminLink;



    public NewProjectPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createProjectButton));
    }
    //delete this method
    public NewProjectPage setProjectDetails (String projectName) {
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
        templateProject.click();
        return this;
    }

    public void signOut(){

         header.singOutPage();
    }

    public void setProjectName(String projectName){
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
    }

    public void chooseProjectTemplate(String template){

        templateProject.click();

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

    public BasePageProject clickCreateProject(){
        createProjectButton.click();
        return new BasePageProject();
    }

    public String getNoticeNewProject(){
        return noticeNewProject.getText();
    }

  public String getProjectName(){

      return projectNameInput.getText();
  }

  public void clickProjectList(){
      projectListLink.click();
  }

    /*
  public boolean theProjectIsProjectList(){
      if(projectListLink.)


  }
    */
  public boolean existStoryMap(){
        if( storyMapLink.isDisplayed())
            return true;
       return  false;

  }

  public void projectAdminClick(){
      projectAdminLink.click();

  }



}
