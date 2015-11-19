package steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/9/15
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {

    LoginPage page;
    MainPage mainPage;

    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){
        page=PageTransporter.getInstance().navigateToLoginPage();

    }

   @When("^I sing in to page with invalid credentials \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
   public void singinInvalidCredentials(String user,String password){


       page.loginFailed(user,password);


   }


    @Then("^A error message should be displayed$")
    public void verifySingIn(){

        String expected=page.getErrorLogin();
        String actual="Wrong sign-in name or password";
        Assert.assertEquals(expected,actual);
    }

    @When("^I sing in to page with \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
    public void singinValidCredentials(String user,String password){

        page.loginSuccess(user,password);

    }

    @Then("^I should login to Mingle successfully$")
    public void stepVerification()
    {
       // page.waitUntilSingOutIsDisplayed();
        mainPage=PageTransporter.getInstance().navigateToMainPage();
       // mainPage.waitByTitlePage();
        String expected=mainPage.getNotice() ;
        //System.out.println(expected);
        Assert.assertEquals("Sign in successful", expected);

    }
     /*
    @When("^Go to new project$")
    public void GoToNewProject(){
        mainPage.projectsLinkClick();


    }
       */
    @Then("^I sing out of page$")
    public void singOutOfPage() {
        mainPage.singOutPage();
        page.waitUntilPageObjectIsLoaded();



    }





}
