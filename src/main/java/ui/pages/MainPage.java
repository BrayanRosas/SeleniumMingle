package ui.pages;

import org.openqa.selenium.By;
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
 * Date: 11/18/15
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
   public class MainPage extends BasePageObject {

    TopMenu topMenu=new TopMenu();
    Header header=new Header();
    boolean sucesscreate=false;
    DeleteProjectPage deleteProjectPage;


    @FindBy(id="notice")
    WebElement loginNotice;

    @FindBy(xpath="//div[@id='flash']/div/div[@id='notice']")
    WebElement templateNotice;


    //create two new web elements for link new project and import project

    @FindBy(xpath = "//a[contains(@href, '/admin/projects/new')]")
    WebElement linkNewProject;

    @FindBy(xpath = "//a[contains(@href, '/admin/projects/import')]")
    WebElement linkImportProject;

    @FindBy(xpath = "//div[@id='main']/div")
    WebElement listOfProjects;

    @FindBy(xpath = "//div[@id='main']//div[@class='project']")
    WebElement listOfTemplate;

    public MainPage(){

      PageFactory.initElements(driver, this);
       waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(header.logOutButton));
    }

    public void waitUntilListProjectIsShowed() {

        wait.until(ExpectedConditions.visibilityOf(listOfProjects));
    }

    public String getNotice(){
        String notice =loginNotice.getText();
        return notice;
    }

    public void  clickLinkNewProject(){
        linkNewProject.click();

    }

    public void  clickLinkImportProject(){
        linkImportProject.click();

    }
    public void singOutPage(){

           header.singOutPage();
    }

    public void GoToDeleteProject(String projectName){

       if(PageTransporter.getInstance().getCurrentURL().contains("projects")){
           header.mingleLogoClick();
           topMenu.projectsLinkClick();

       }
        waitUntilListProjectIsShowed();
        listOfProjects.findElement(By.xpath("//a[contains(@href, '/delete/"+projectName.toLowerCase()+"')]")).click();
        deleteProjectPage=new DeleteProjectPage();
        deleteProjectPage.confirmDeleteProject(projectName);

    }

    public Boolean verifyIfExistProjectList(String projectName){
        return isPresent(By.xpath("//div[@id='main']/div//a[contains(@href, '/projects/"+projectName.toLowerCase()+"')]"));

    }


    public void createTemplateThisProject(String projectName){
        waitUntilListProjectIsShowed();
        listOfProjects.findElement(By.xpath("//a[@id='create_template_"+projectName.toLowerCase()+"']")).click();
        wait.until(ExpectedConditions.visibilityOf(templateNotice));

    }

    public boolean isTemplateCreated(String message){

        String successMessage=templateNotice.getText();

      if(successMessage.contains(message))  {
          sucesscreate=true;
      }
       else{
          sucesscreate=false;

      }
        return sucesscreate;
    }


    public boolean isTemplateInTheList(String projectName){

        return isPresent(By.xpath("//div[@id='main']//div[@class='project']/div[@class='project-description']//a[text()='" + projectName +" "+"template"+ "']"));

    }

    public void goToTemplateLIst(){

        topMenu.adminProjectLink.click();
        topMenu.adminProjectTemplateOption.click();
        wait.until(ExpectedConditions.visibilityOf(listOfTemplate));



    }



   /*
    public MainPage deleteProject(String projectName){

        String currentUrl= PageTransporter.getInstance().getCurrentURL();
        if(currentUrl.contains(projectName)){
            adminProjectLink.click();
            wait.until(ExpectedConditions.visibilityOf(deleteProjectLink));
            deleteProjectLink.click();
            deleteConfirmButton.click();
            projectNameInput.sendKeys(projectName);
            submitDeleteButton.click();

        }
        else{

            // main=headerProject.mingleLogoClick();
            findProjectAndClickOnDelete(projectName);
            deleteConfirmButton.click();
            projectNameInput.sendKeys(projectName);
            submitDeleteButton.click();

        }

        return new MainPage();

    }
    */

}
