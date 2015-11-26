package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/18/15
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
   public class MainPage extends BasePageObject {

    //TopMenu topMenu=new TopMenu();
    //Header header;
    Header header=new Header();


    @FindBy(id="notice")
    WebElement loginNotice;
    //create two new web elements for link new project and import project

    @FindBy(xpath = "//a[contains(@href, '/admin/projects/new')]")
    WebElement linkNewProject;

    @FindBy(xpath = "//a[contains(@href, '/admin/projects/import')]")
    WebElement linkImportProject;

   //WebElement logOutButton=header.getSingOut();

    /*@FindBy(xpath="//a[contains(@href,'/profile/logout')]")
    WebElement logOutButton;*/
    /*
    //@FindBy(linkText = "Projects")
    @FindBy(xpath = "//div[@id='header-pills']/ul/li[2]")
    WebElement projectsLink;   // go to list of project
      */

    //@FindBy(xpath="//a[contains(@href,'/profile/logout')]")
    //@FindBy(id="logout"
    //@FindBy(css="#logout")
    //@FindBy(linkText = "Sign out")

   // @FindBy(xpath="//a[contains(@href,'/profile/logout')]")
    //WebElement logOutButton;

    /*
    @FindBy(id="title")
    WebElement titlePage;
      */
   // @FindBy(id="project-list")
   // WebElement projectListLink;

    //WebElement logOutButton=header.getSingOut();

    public MainPage(){

      PageFactory.initElements(driver, this);
       waitUntilPageObjectIsLoaded();

    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(header.logOutButton));
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
            //return new LoginPage();


      //  System.out.println("The element sing  out does not enable");
        //return new MainPage();
    }
      /*
    public void waitByTitlePage() {
        wait.until(ExpectedConditions.visibilityOf(titlePage));

    }
        */

    /*
    public void  projectsLinkClick(){
        String classValue=topMenu.projectsLink.getAttribute("class");
        if(classValue=="header-menu-pill selected")  {
            clickLinkNewProject();
        }
        else{
            topMenu.projectsLink.click();
            clickLinkNewProject();

        }


    } */
}
