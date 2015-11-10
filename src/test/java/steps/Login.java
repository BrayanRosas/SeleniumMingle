package steps;

import Framework.DriverManagement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/9/15
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {

    private DriverManagement instance=DriverManagement.getInstance();
    private WebDriver driver;


    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){

        driver=instance.getDriver();
        driver.get("https://jala-foundation.mingle.thoughtworks.com/projects/your_first_project");
        driver.manage().window().maximize();
    }

    @When("^I sing in to page$")
    public void singIn()
    {
          driver.findElement(By.id("user_login"))
          .sendKeys("brayan_rosas");
          driver.findElement(By.id("user_password"))
           .sendKeys("Bgrf44360303bpm.");
          driver.findElement(By.name("commit")).click();

    }

    @Then("^I should login to Mingle successfully$")
    public void Assert()
    {
         WebElement elem= driver.findElement(By.xpath("//div[@id='title']/span/a")) ;
         String expected=elem.getText();
         System.out.println(expected);
         Assert.assertEquals("Your First Project", expected);
    }
}
