package steps;
import common.CommonMethods;
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

    LoginPage loginPage;//=new LoginPage();
    MainPage mainPage;

   @When("^I sing in to page with invalid credentials \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
   public void singinInvalidCredentials(String user,String password){
       loginPage=new LoginPage();
       loginPage.loginFailed(user,password);
   }

    @Then("^A error message should be displayed$")
    public void verifySingIn(){

        String expected=loginPage.getErrorLogin();
        String actual="Wrong sign-in name or password";
        Assert.assertEquals(expected,actual);
    }

    @When("^I sing in to page with the user \"([^\\\"]*)\" and password \"([^\\\"]*)\"$")
    public void singInToMainPage(String user,String password){

        if(!CommonMethods.theUserIsLogIn()){

            singinValidCredentials(user,password);

        }
        else{
           PageTransporter.getInstance().navigateToMainPage();

        }

    }

    @Given("^I sing in to main page with valid credentials \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
    public void singinValidCredentials(String user,String password){
        loginPage=new LoginPage();
        mainPage=loginPage.loginSuccess(user,password);
    }

















    @Then("^I should login to Mingle successfully$")
    public void stepVerification()
    {
        String expected=mainPage.getNotice() ;
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
      //  mainPage.waitUntilPageObjectIsLoaded();
        mainPage.singOutPage();
    }
}
