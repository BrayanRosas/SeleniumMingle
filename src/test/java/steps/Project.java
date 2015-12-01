package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.BasePageProject;
import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.NewProjectPage;
import ui.pages.Tab;

import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/11/15
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Project {

    LoginPage loginPage;
    MainPage mainPage;
    NewProjectPage newProjectPage;
    BasePageProject baseProject;
    Tab tabPage;

    @And("^I navigate to New Project Page$")
    public void navigateProjectPage(){
        mainPage=PageTransporter.getInstance().navigateToMainPage();
        // mainPage.waitUntilLinkNewIsShowed();
         mainPage.clickLinkNewProject();
    }


    @When("^I fill the \"([^\\\"]*)\"$")
     public void typeProjectName(String projectName){
        newProjectPage=PageTransporter.getInstance().navigateToProjectPage();
        newProjectPage.setProjectName((projectName));

    }

     @And("^I choose a project type \"([^\\\"]*)\"$")
     public void setProjectDetails(String projectTemplate){
         newProjectPage.chooseProjectTemplate(projectTemplate);
     }

    @And("^I set advanced project fields: \"([^\\\"]*)\", \"([^\\\"]*)\",\"([^\\\"]*)\",\"([^\\\"]*)\"$")
    public void setProjectAdvancedFields(String timezone,String dateFormat,String precision,String imagePath){
         //Refactor this for working  from config file
        newProjectPage.setAdvancedProjectDetails(timezone,dateFormat,precision,imagePath);
    }

    @And("^I save the project$")
    public void createProject(){
        baseProject=newProjectPage.createProject();
    }


    @Then("^a new project page with the project name \"([^\\\"]*)\" should be created$")
    public void verifyProjectPage(String projectName)
    {
        String currentUrl=PageTransporter.getInstance().getCurrentURL();
        System.out.println("---------"+currentUrl);
        String expected="https://jala-foundation.mingle.thoughtworks.com/projects/"+projectName.toLowerCase()+"/overview" ;
        Assert.assertEquals(currentUrl, expected);
    }


    @And("^the project name \"([^\\\"]*)\" is in the message \"([^\\\"]*)\"$")
    public void verifySuccessfullyProjectCreated(String projectName,String message){

        String actual=newProjectPage.getNoticeNewProject();
        String expected="Project "+projectName+" "+message;
        System.out.println(expected);
        Assert.assertEquals(actual,expected);

    }

    @And("^I have the \"([^\\\"]*)\\\" on the  project list$")
    public void verifyProjectTemplate(String projectName){
        mainPage=baseProject.clickListProject();
        boolean actual=mainPage.verifyIfExistProjectList(projectName);
        Assert.assertEquals(actual,true);

    }

    @And("^delete the \"([^\\\"]*)\" project from the main page$")
    public void deleteProject(String projectName){
    mainPage.GoToDeleteProject(projectName);

    }

    @Given ("^I create the project with project name \"([^\\\"]*)\" and project type \"([^\\\"]*)\"$")
    public void createProjectSimple(String projectName,String projectType ){

        mainPage=PageTransporter.getInstance().navigateToMainPage();
        mainPage.clickLinkNewProject();
        newProjectPage=PageTransporter.getInstance().navigateToProjectPage();
        newProjectPage.setProjectName(projectName);
        newProjectPage.chooseProjectTemplate(projectType);
        baseProject=newProjectPage.createProject();

    }

    @And ("^I go at my list projects$")
    public void goToMainPageFromProjectPage(){

       mainPage= baseProject.clickListProject();

    }

    @When ("^I create the project with same project name \"([^\\\"]*)\" and type project \"([^\\\"]*)\"$")
    public void createSameProject(String projectName,String projectType ){

        mainPage.clickLinkNewProject();
        newProjectPage=PageTransporter.getInstance().navigateToProjectPage();
        newProjectPage.setProjectName(projectName);
        newProjectPage.chooseProjectTemplate(projectType);
        newProjectPage=newProjectPage.createSameProject();

    }

    @And("^An Error message \"([^\\\"]*)\" should be displayed$")
     public void  errorCreateProjectIsShowed(String textError){

        boolean expected=true;

        Assert.assertEquals( newProjectPage.textErrorIsPresent(textError),expected);
    }

    @And("^I invite a new user to the current project with the email \"([^\\\"]*)\"$")
    public void  inviteUser(String email){
      baseProject.inviteUser(email);

      }

    @Then("^the user \"([^\\\"]*)\" should be in the Team List of the project \"([^\\\"]*)\"$")
        public void isUserInTeamList(String email ,String projectName){

       baseProject.isUserInTeamList(email);

    }

    @And ("^I change the member roll \"([^\\\"]*)\"$")
        public void changeRollMember(String roll){

               baseProject.changeRollMemberTo();

    }

    @And ("^I edit the Tab name \"([^\\\"]*)\" to \"([^\\\"]*)\"$")
     public void editTabTo(String actualName,String newName) {
         baseProject.searchElementTopMenuAndClick(actualName);
         tabPage=baseProject.changeTabNameTo(actualName,newName);

    }

    @And ("^I create a new Value \"([^\\\"]*)\" on tab \"([^\\\"]*)\"$")
    public void createNewValue(String newValueName,String tabName) {
        tabPage.createNewValue(newValueName);

    }

    @And ("^I create a new Value \"([^\\\"]*)\" on default Agile tab \"([^\\\"]*)\"$")
    public void createNewValueInto(String newValueName,String tabName) {

        baseProject.searchElementTopMenuAndClick(tabName);
        tabPage=new Tab();
        tabPage.createNewValue(newValueName);
    }

    @And ("^I create the card \"([^\\\"]*)\"  inside the value \"([^\\\"]*)\" with estimation \"([^\\\"]*)\" and owner \"([^\\\"]*)\" and cardType \"([^\\\"]*)\"$")
    public void createNewCardInto(String cardName,String valueName,String estimation,String owner,String cardType) {

        baseProject.getBottomBar().createNewCard(cardName,valueName,estimation,owner,cardType);

    }

    @And ("^I create a template of the project \"([^\\\"]*)\"$")
    public void createTemplateOf(String projectName) {

       mainPage=baseProject.clickListProject();
       mainPage.createTemplateThisProject(projectName);

    }


    @And ("^the message \"([^\\\"]*)\" should be showed$")
    public void isTemplateCreated(String message) {

        Assert.assertEquals( mainPage.isTemplateCreated(message),true);

    }

    @Then ("^The template of project \"([^\\\"]*)\" is the template project list$")
    public void isTemplateInList(String projectName) {

        mainPage.goToTemplateLIst();
        Assert.assertEquals( mainPage.isTemplateInTheList(projectName),true);
    }

    @And ("^An message \"([^\\\"]*)\" is displayed$")
    public void isCardCreated(String message) {

        Assert.assertEquals(tabPage.isCardCreated(message),true);
    }

    @And ("^the card \"([^\\\"]*)\" is inside the Value \"([^\\\"]*)\"$")
    public void isCardInValue(String cardName,String valueName) {

        Assert.assertEquals(tabPage.isCardInValue(valueName,cardName),true);
    }

    @And ("^the card \"([^\\\"]*)\" is in the card list of the project$")
    public void isCardInCardList(String cardName) {

        Assert.assertEquals(baseProject.isCardInListCard(cardName),true);

    }

    @When ("^the card \"([^\\\"]*)\" is moved from \"([^\\\"]*)\" to \"([^\\\"]*)\" Value in the Tab \"([^\\\"]*)\"$")
    public void moveCardToDragAndDrop(String cardName,String origin,String destination,String tabName) {
           baseProject.searchElementTopMenuAndClick(tabName);
           tabPage=new Tab();
           tabPage.moveCardTo(cardName,origin,destination);
    }

    @When ("^I change the status of card \"([^\\\"]*)\" to \"([^\\\"]*)\" in the value \"([^\\\"]*)\"$")
    public void changeCardStatus(String cardName,String status,String value) {

    }


    @When ("^hide the value \"([^\\\"]*)\" of Tab \"([^\\\"]*)\"$")
    public void goToTab(String valueName,String tabName) {
        tabPage=  baseProject.goToTab(tabName);
        tabPage.hideTab(tabName,valueName);

    }








}
