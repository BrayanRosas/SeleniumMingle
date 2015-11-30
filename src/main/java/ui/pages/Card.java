package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/29/15
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Card extends BasePageObject {

    @FindBy(id= "card_type_name")
    WebElement cardType;



    @FindBy(xpath= "//input[@id='card_name']")
    WebElement cardName;


    /*
    @FindBy(xpath= "//span[@id='userpropertydefinition_1683")
    WebElement cardEstimateSelector;
      */
    @FindBy(xpath= "//div[@id='card-properties']/div/span[@title='Estimate']/following-sibling::span")
    WebElement cardEstimateSelector;

    @FindBy(css= "input.dropdown-options-filter")
    WebElement cardEstimateInput;



    @FindBy(xpath= "//div[@id='card-properties']/div/span[@title='Status']/following-sibling::span")
    WebElement cardStatusSelector;

    @FindBy(xpath= "//div[@id='card-properties']/div/span[@title='Owner']/following-sibling::span")
    WebElement cardOwnerSelector;

    @FindBy(id= "quick_add_button")
    WebElement addCardButton;



    //span[@id='userpropertydefinition_1683_option_']
    //span[@id='userpropertydefinition_1684_option_']
    //span[@id='userpropertydefinition_1685_option_']




    public Card() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(cardName));
    }


}
