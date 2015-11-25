package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/21/15
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TopMenu extends BasePageObject {

    @FindBy(xpath = "//div[@id='header-pills']/ul/li/a")
    WebElement programsLink;   // go to list of project

    @FindBy(xpath = "//div[@id='header-pills']/ul/li[2]")
    WebElement projectsLink;   // go to list of project

    public TopMenu(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(projectsLink));
    }

    public void  programsLinkClick(){

        programsLink.click();
    }

    public void  projectsLinkClick(){

        projectsLink.click();
    }

}
