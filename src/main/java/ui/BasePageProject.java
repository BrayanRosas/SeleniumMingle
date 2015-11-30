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
 boolean isCardList;

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
       Options of Menu Admin Project
     */

    @FindBy(linkText="Team members")
    WebElement userTeamLink;

    @FindBy(xpath="//a[contains(text(),'Delete')]")
    WebElement deleteProjectLink;

   /*
   User option
    */
    @FindBy(id="select_permission_user_1_drop_link")
    WebElement rollUserSelector;

    @FindBy(xpath="//li[@id='select_permission_user_1_option_Project administrator']/text")
    WebElement rollSelectedOption;

    /*
    top menu of specific project
     */
    @FindBy(xpath="//ul[@id='hd-nav']")
    WebElement topMenu;

    @FindBy(xpath="//ul[@id='hd-nav']//li//i")
    WebElement tabEditIcon;

    @FindBy(id="tab-name")
    WebElement tabNameInput;

    @FindBy(xpath="//input[@value='Save']")
    WebElement tabSaveButton;

    @FindBy(id="link-to-this-page")
    WebElement updateUrlLink;

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

    public void changeRollMemberTo(){
        adminProjectLink.click();
        wait.until(ExpectedConditions.visibilityOf(userTeamLink));
        userTeamLink.click();
        rollUserSelector.click();
        rollSelectedOption.click();
        wait.until(ExpectedConditions.visibilityOf(topMenu));

    }

    public void exportProject(){
        adminProjectLink.click();

        wait.until(ExpectedConditions.visibilityOf(topMenu));

    }


    public void searchElementTopMenuAndClick(String title ) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='hd-nav']//li//a[@title='"+title+"']")));
        driver.findElement(By.xpath("//ul[@id='hd-nav']//li//a[@title='" + title + "']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='hd-nav']//li//a[@title='"+title+"']")));


    }

    public Tab changeTabNameTo(String tabActualName,String tabNewName){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='hd-nav']//li//a[@title='"+tabActualName+"']")));
        tabEditIcon.click();
        tabNameInput.clear();
        tabNameInput.sendKeys(tabNewName);
        tabSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(updateUrlLink));
        return new Tab();
    }


   public BottomBar getBottomBar(){

       return new BottomBar();
   }

    public boolean isCardInListCard(String cardName){

        allProjectLink.click();
        if(isPresent(By.xpath("//table[@id='cards']/tbody/tr/td[@class='card-name']/a[contains(text(),'"+cardName+"')]"))){
            isCardList=true;
        }
        else{
            isCardList=false;
        }
        return isCardList;

    }





}
