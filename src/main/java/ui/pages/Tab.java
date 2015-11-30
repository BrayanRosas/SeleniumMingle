package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/29/15
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tab extends BasePageObject {
    String name;

    //Web element to add and search Values ,Value is a col that contains cards
    @FindBy(css = "i.fa.fa-plus-circle")
    WebElement plusValueSelector;




     //filter of Value
    @FindBy(xpath = "xpath=(//input[@name='filter'])[2]")
    WebElement filterValueInput;

    @FindBy(xpath = "//div[@id='add_dimension_widget']/div/div/form[2]/a")
    WebElement plusValueLink;

    @FindBy(xpath = "//input[@name='laneName']")
    WebElement createValueInput;




    // the  table head that contains all Value created
    @FindBy(xpath = "//table[@id='swimming-pool']/thead/tr")
    WebElement valuesTableHead;

     //The table body that contains all cards stored in Values
    @FindBy(xpath = "//table[@id='swimming-pool']/tbody/tr")
    WebElement valuesTableBody;


    @FindBy(xpath = "//a[@class='inplace-add fa fa-plus-circle']")
    WebElement addCardLink;


    @FindBy(xpath = "//div[@id='notice']")
    WebElement tabNotice;






    //table[@id='swimming-pool']/thead/tr/th[@data-lane-value='In Dev']
    //table[@id='swimming-pool']/tbody/tr/td[@lane_value='In Dev']

    public Tab(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(plusValueSelector));
    }

    public void  createNewValue(String nameNewValue){

          plusValueSelector.click();
          plusValueLink.click();
          createValueInput.sendKeys(nameNewValue);
          driver.findElement(By.xpath("//input[@name='laneName']")).sendKeys(Keys.ENTER);
          wait.until(ExpectedConditions.visibilityOf(plusValueSelector));
          if(!isPresent(By.xpath("//table[@id='swimming-pool']/tbody/tr/td[@lane_value='"+nameNewValue+"']"))){

              plusValueSelector.click();
              filterValueInput.sendKeys(nameNewValue);
              driver.findElement(By.xpath("xpath=(//input[@name='filter'])[2]")).sendKeys(Keys.ENTER);

          }

         System.out.println("The element is already visible");


    }

    public void createNewCardInTo(String nameValue){


        Actions action = new Actions(driver);
        WebElement we =driver.findElement(By.xpath("//table[@id='swimming-pool']/tbody/tr/td[@lane_value='"+nameValue+"']"));
        action.moveToElement(we).build().perform();
        addCardLink.click();



    }


    public void isCardCreated(String message){
        System.out.println(tabNotice.getText());
        System.out.println(message);
        tabNotice.getText();


    }

}
