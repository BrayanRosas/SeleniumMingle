package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.NewProjectPage;

import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/11/15
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Project {

    LoginPage page;
    MainPage mainPage;
    NewProjectPage newProjectPage;

    String projectName="Test";
    String projectTemplate="Scrum";
    String timezone="label=(GMT-04:00) La Paz";
    String dateFormat="label=dd/mm/yyyy";
    String precision="3";
    String imagePath="C:\\Users\\BrayanRosas\\Pictures\\ProjectImages\\TestImage.jpeg";


    @Given("^I navigate at Login Page$")
    public void navigateLoginPage(){
        page= PageTransporter.getInstance().navigateToLoginPage();
    }

    @And("^I sing in successfully at Login Page$")
    public void singInLoginPage(){
       // page.waitUntilPageObjectIsLoaded();
        page.setUserNameInput("brayan_rosas");
        page.setPasswordInput("Bgrf44360303bpm.");
        page.loginButtonClick();
    }

    @And("^I navigate to New Project Page$")
    public void navigateProjectPage(){
        mainPage=PageTransporter.getInstance().navigateToMainPage();
         mainPage.waitUntilLinkNewIsShowed();
         mainPage.clickLinkNewProject();
    }


    @When("^I fill the \"([^\\\"]*)\"$")
     public void typeProjectName(String projectName){
        newProjectPage=PageTransporter.getInstance().navigateToProjectPage();
        newProjectPage.setProjectName((projectName));

    }

     @And("^I choose a methodology \"([^\\\"]*)\"$")
     public void setProjectDetails(String projectTemplate){
         newProjectPage.chooseProjectTemplate(projectTemplate);
     }

    @And("^I set advanced project fields$")
    public void setProjectAdvancedFields(){
         //Refactor this for working  from config file
        newProjectPage.setAdvancedProjectDetails(timezone,dateFormat,precision,imagePath);
    }

    @And("^I create the project$")
    public void createProject(){
        newProjectPage.clickCreateProject();
    }


    @Then("^I should be in a project \"([^\\\"]*)\" page Overview$")
    public void verifyProjectPage(String projectName)
    {
        String currentUrl=PageTransporter.getInstance().getCurrentURL();
        System.out.println(currentUrl);
        String expected="https://jala-foundation.mingle.thoughtworks.com/projects/"+projectName+"/overview" ;
        Assert.assertEquals(currentUrl, expected);
    }




    @And("^the  Project \"([^\\\"]*)\\\" should be successfully created.$")
    public void verifySuccessfullyProjectCreated(String projectName){

        String actual=newProjectPage.getNoticeNewProject();
        String expected="Project "+projectName+" successfully created.";
        System.out.println(expected);
        Assert.assertEquals(actual,expected);

    }



    @And("^I have a Card Wall according with the \"([^\\\"]*)\"$")
    public void verifyProjectTemplate(String typeCard){

        //Assert.assertEquals(true,newProjectPage.existStoryMap());

    }

    @And("^I have the \"([^\\\"]*)\" on the  project list$")
    public void projectIsProjectList(String projectName){
        newProjectPage.clickProjectList();

    }

    /*
    Delete project methods
     */
    @Given ("^I have a new project with \"([^\\\"]*)\" created$")
    public void createBasicProject(String projectName){
      mainPage.waitUntilLinkNewIsShowed();
      mainPage.clickLinkNewProject();
      newProjectPage.setProjectName(projectName);
      newProjectPage.clickCreateProject();

     }

    @When("^I go to project admin$")
    public void goToProjectList(){
      newProjectPage.projectAdminClick();
    }

    @And("^I select the project with \"([^\\\"]*)\"$")
    public void selectProjectToDeleted(String projectName){



    }

    @And("^I click on the delete$")
    public void ClickDeleteProject(String projectName){



    }
    @And("^I type the \"([^\\\"]*)\" to confirm the deleting of project$")
    public void typeProjectNameToConfirm(String projectName){



    }
    @Then("^The project with the name \"([^\\\"]*)\" has been deleted successfully$")
    public void VerifyDeleteSuccessfully(String projectName){


    }


}
