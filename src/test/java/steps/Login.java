package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.PageTransporter;
import ui.pages.LoginPage;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/9/15
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {

    LoginPage page;

    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){
        page=PageTransporter.getInstance().navigateToLoginPage();
    }

    @When("^I sing in to page$")
    public void singIn()
    {
            page.setUserNameInput("brayan_rosas");
            page.setPasswordInput("Bgrf44360303bpm.");
            page.clickLoginBtnFailed();
    }

    @Then("^I should login to Mingle successfully$")
    public void Assert()
    {
        String expected=page.getNotice() ;
        Assert.assertEquals("Sign in successful",expected);
    }
}
