package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.pages.Header;
import ui.pages.HeaderProject;
import ui.pages.MainPage;
import ui.pages.TopMenu;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/23/15
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasePageProject extends BasePageObject {

 Header headerProject=new HeaderProject();
 //TopMenu topMenu=new TopMenu();
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

    @FindBy(xpath="//a[contains(text(),'Delete')]")
    WebElement deleteProjectLink;

    @FindBy(id="confirm_bottom")
    WebElement deleteConfirmButton;

    @FindBy(xpath="//input[@name='projectName']")
    WebElement projectNameInput;

    @FindBy(xpath="//input[@value='I understand the consequences, delete this project']")
    WebElement submitDeleteButton;


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

    public MainPage clickListProject(){

        return headerProject.mingleLogoClick();

    }

    public MainPage deleteProject(String projectName){
        adminProjectLink.click();
        wait.until(ExpectedConditions.visibilityOf(deleteProjectLink));
        deleteProjectLink.click();
        deleteConfirmButton.click();
        projectNameInput.sendKeys(projectName);
        submitDeleteButton.click();
        return new MainPage();

    }




}
