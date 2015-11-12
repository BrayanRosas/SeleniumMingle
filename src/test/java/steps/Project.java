package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.NewProjectPage;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/11/15
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Project {

    LoginPage page;
    NewProjectPage newProjectPage;

    @Given("^I navigate at Login Page$")
    public void navigateLoginPage(){
        page= PageTransporter.getInstance().navigateToLoginPage();
    }

    @And("^I sing in successfully at Login Page$")
    public void singInLoginPage(){
        page.waitUntilPageObjectIsLoaded();
        page.setUserNameInput("brayan_rosas");
        page.setPasswordInput("Bgrf44360303bpm.");
        page.clickLoginBtnFailed();

    }

    @And("^I navigate at New Project Page$")
    public void navigateProjectPage(){
         page.waitUntilLinkNewIsShowed();
         page.clickLinkNewProject();

    }

    @When("^I choose a methodology template$")
    public void selectTemplate()

    {
      //  newProjectPage.waitUntilPageObjectIsLoaded();
        newProjectPage=PageTransporter.getInstance().navigateToProjectPage();
        newProjectPage.setProjectDetails("Test");
    }

    @And("^I set the project details$")
       public void setProjectDetails(){
    }

    @And("^I set advanced project fields$")
    public void setProjectAdvancedFields(){
         //Refactor this for working  from config file
        newProjectPage.setAdvancedProjectDetails("label=(GMT-04:00) La Paz","label=dd/mm/yyyy","3","C:\\Users\\BrayanRosas\\Pictures\\ProjectImages\\TestImage.jpeg");


    }

    @And("^I created the project$")
    public void createProject(){

        newProjectPage.clickCreateProject();
    }

    @Then("^I should be in a project \"Test\" page Overview$")
    public void verifyProjectPage()
    {

    }

    @And("^I have the  Project \"Test\" successfully created.$")
    public void verifySuccessfullyProjectCreated(){

    }
    @And("^I have a Card Wall according with my choose template \"Scrum\"$")
    public void verifyProjectTemplate(){


    }
}
