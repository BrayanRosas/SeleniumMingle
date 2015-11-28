package ui.pages;

import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePageProject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/24/15
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderProject extends Header {

    boolean resp;
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

    //Specific project button

    @FindBy(xpath = "//div[@id='title']/span/a")
    WebElement specificProjectLink;

    @FindBy(css = "div.projects-caret")
    WebElement specificProjectLinkDeployed;

    @FindBy(xpath = "//input[@name='filter']")
    WebElement specificProjectFilter;

    @FindBy(xpath = "//a[contains(text(),'New project')]")
    WebElement newProjectLink;

    @FindBy(xpath = "//ul[@class='murmurs-panel']")
    WebElement getSpecificProjectChatList;

    public void searchProject(String projectName){

        specificProjectLinkDeployed.click();
        specificProjectFilter.sendKeys(projectName);


    }

    public NewProjectPage  goToNewProjectFromHeaderProject(){
        specificProjectLinkDeployed.click();
        newProjectLink.click();
        return new NewProjectPage();
    }

    public void  searchCardsMurmursAndPages(){



    }

    public void sendMurmurMessage(String message){
        murmursLink.click();
        murmursTextArea.sendKeys(message);
        murmursSendButton.click();
        murmursLink.click();

        //maybe should return at the same page?
    }

    public boolean ExistMessageListChat(String message){

        List<WebElement> elements=getSpecificProjectChatList.findElements(By.tagName("li"));
        for(WebElement elem:elements){

            if(message==elem.getText())
            {

                resp=true;
            }
           resp=false;
         }

            return resp;
    }
      /*
    public void clickToProjectList(){

        mingleLogoClick();

    }
        */
  }



