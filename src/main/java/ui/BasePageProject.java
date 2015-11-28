package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.*;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/23/15
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasePageProject extends BasePageObject {

 Header headerProject=new HeaderProject();
 BottomBar supportBar=new BottomBar();

    @FindBy(xpath="//input[@id='q']")
    WebElement searchInput;

    @FindBy(xpath="//input[@id='search_button']")
    WebElement searchButton;

    @FindBy(xpath="//div[@id='murmurs-drop-down']/div/a")
    WebElement murmursLink;

    @FindBy(xpath="//div[@id='murmurs-drop-down']/div[2]/div/textarea")
    WebElement murmursTextArea;

    @FindBy(xpath=" //div[@id='murmurs-drop-down']/div[2]/ul/li[2]/button")
    WebElement murmursSendButton;
    /*
    ProjectBase menu
     */
    @FindBy(id="tab_overview_link")
    WebElement overviewProjectLink;

    @FindBy(id="tab_all_link")
    WebElement allProjectLink;

    @FindBy(id="tab_history_link")
    WebElement historyProjectLink;

    @FindBy(id="tab_project_admin_link")
    WebElement adminProjectLink;
    /*

     */
    @FindBy(linkText="Team members")
    WebElement userTeamLink;

    @FindBy(xpath="//a[contains(text(),'Delete')]")
    WebElement deleteProjectLink;

    MainPage main;
    DeleteProjectPage deletePage;
    boolean projectFounded=false;
    boolean isProjectPage;

    public BasePageProject() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(adminProjectLink));
    }

    public void signOut(){

        headerProject.singOutPage();

    }

    public void inviteUser(String email){
        supportBar.inviteUser(email) ;

    }

    public MainPage clickListProject(){

        return headerProject.mingleLogoClick();

    }

    public void GoToDeleteProject(String projectName){
            adminProjectLink.click();
            wait.until(ExpectedConditions.visibilityOf(deleteProjectLink));
            deleteProjectLink.click();
            deletePage=new DeleteProjectPage();
            deletePage.confirmDeleteProject(projectName);
    }

    public boolean verifyIfExistProjectList(String projectName){

            projectFounded=main.verifyIfExistProjectList(projectName);
        return projectFounded;
    }

    public boolean IsInProjectPage(String projectName){

        String currentUrl=PageTransporter.getInstance().getCurrentURL();
            if(currentUrl.contains(projectName))
                isProjectPage=true;
            isProjectPage=false;
        return isProjectPage;
    }


    public BottomBar getSupportBar(){

        return  supportBar;

    }

    public boolean isUserInTeamList(String email){

        adminProjectLink.click();
        wait.until(ExpectedConditions.visibilityOf(userTeamLink));
        userTeamLink.click();
        return isPresent(By.xpath("//table[@id='users']//tbody//td[@class='email'][text()='" + email + "']"));


    }





}
